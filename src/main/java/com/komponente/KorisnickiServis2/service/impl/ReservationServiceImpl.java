package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.client.userservice.dto.ClientRentingDaysDto;
import com.komponente.KorisnickiServis2.client.userservice.dto.DiscountDto;
import com.komponente.KorisnickiServis2.client.userservice.dto.UserReservationDto;
import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.ReservationCancelDto;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReservationDto;
import com.komponente.KorisnickiServis2.dto.UniversalEmailDto;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.helper.MessageHelper;
import com.komponente.KorisnickiServis2.mapper.ReservationMapper;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.repository.VehicleRepository;
import com.komponente.KorisnickiServis2.service.ReservationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;
    private VehicleRepository vehicleRepository;
    private RestTemplate userServiceRestTemplate;
    private JmsTemplate jmsTemplate;
    private MessageHelper messageHelper;
    private String destination;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, VehicleRepository vehicleRepository,
                                  RestTemplate userServiceRestTemplate, JmsTemplate jmsTemplate, MessageHelper messageHelper,
                                  @Value("${destination.emailDestination}")String destination) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.vehicleRepository = vehicleRepository;
        this.userServiceRestTemplate = userServiceRestTemplate;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.destination = destination;
    }

    @Override
    public ReservationDto createReservation(ReservationCreateDto reservationCreateDto) {
        ResponseEntity<DiscountDto> discountDtoResponseEntity = userServiceRestTemplate.exchange("/user/" +
                reservationCreateDto.getUserId() + "/discount", HttpMethod.GET, null, DiscountDto.class);



        //Kada reservationCreateDto bude imao ceo Vehicle a za sada radimo kao da ima samo ID od Vehicle, kada se to popravi, treba da se sredi VehicleMapper
        //Long price = (long) reservationCreateDto.getVehicle().getPrice() / 100L * Long.valueOf(discountDtoResponseEntity.getBody().getDiscount());
        //Reservation reservation=new Reservation(reservationCreateDto.getVehicle(), reservationCreateDto.getUserId(), reservationCreateDto.getDate_from(), reservationCreateDto.getDate_to(),price);
        Vehicle vehicle=vehicleRepository.findById(reservationCreateDto.getUserId()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));
        Long price = (long)vehicle.getPrice()-(long) vehicle.getPrice() / 100L * Long.valueOf(discountDtoResponseEntity.getBody().getDiscount());
        Reservation reservation=new Reservation(vehicle, reservationCreateDto.getUserId(), reservationCreateDto.getDate_from(), reservationCreateDto.getDate_to(),price);
        //


        ResponseEntity<UserReservationDto> userReservationDtoResponseEntity = userServiceRestTemplate.exchange("/user/" +
                reservationCreateDto.getUserId() + "/find", HttpMethod.GET, null, UserReservationDto.class);

        String name=userReservationDtoResponseEntity.getBody().getFirstName();
        String lastName=userReservationDtoResponseEntity.getBody().getLastName();
        String email=userReservationDtoResponseEntity.getBody().getEmail();





        reservationRepository.save(reservation);
        UniversalEmailDto universalEmailDto=new UniversalEmailDto("Reservation",email,name,lastName,"",reservationCreateDto.getVehicleId(),String.valueOf(vehicle.getModel()),String.valueOf(vehicle.getType()),reservationCreateDto.getDate_from(),reservationCreateDto.getDate_to(),"","");
        jmsTemplate.convertAndSend(destination,messageHelper.createTextMessage(universalEmailDto));


        long diff=reservationCreateDto.getDate_to().getTime()- reservationCreateDto.getDate_from().getTime();
        ClientRentingDaysDto clientRentingDaysDto=new ClientRentingDaysDto(reservationCreateDto.getUserId(), (int) TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS));
        HttpEntity<ClientRentingDaysDto> request = new HttpEntity<>(clientRentingDaysDto);

        userServiceRestTemplate.exchange("/client/" +
                  "/updateRentingDays", HttpMethod.POST, request, ClientRentingDaysDto.class);


        return reservationMapper.reservationToReservationDto(reservation);
    }

    @Override
    public ReservationDto cancelReservation(ReservationCancelDto reservationCancelDto) {
        long diff=reservationCancelDto.getDate_to().getTime()- reservationCancelDto.getDate_from().getTime();
        diff=-diff;
        ClientRentingDaysDto clientRentingDaysDto=new ClientRentingDaysDto(reservationCancelDto.getUserId(), (int) TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS));
        HttpEntity<ClientRentingDaysDto> request = new HttpEntity<>(clientRentingDaysDto);

        userServiceRestTemplate.exchange("/client/" +
                "/updateRentingDays", HttpMethod.POST, request, ClientRentingDaysDto.class);

        reservationRepository.delete(reservationMapper.reservationCancelDtoToReservation(reservationCancelDto));
        ResponseEntity<UserReservationDto> userReservationDtoResponseEntity = userServiceRestTemplate.exchange("/user/" +
                reservationCancelDto.getUserId() + "/find", HttpMethod.GET, null, UserReservationDto.class);

        String name=userReservationDtoResponseEntity.getBody().getFirstName();
        String lastName=userReservationDtoResponseEntity.getBody().getLastName();
        String email=userReservationDtoResponseEntity.getBody().getEmail();

        UniversalEmailDto universalEmailDto=new UniversalEmailDto("CancelReservation",email,name,lastName,"",reservationCancelDto.getVehicle().getId(),"","",reservationCancelDto.getDate_from(),reservationCancelDto.getDate_to(),"","");
        jmsTemplate.convertAndSend(destination,messageHelper.createTextMessage(universalEmailDto));


        return reservationMapper.reservationToReservationDto(reservationMapper.reservationCancelDtoToReservation(reservationCancelDto));
    }
}
