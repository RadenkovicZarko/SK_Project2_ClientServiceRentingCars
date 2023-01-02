package com.komponente.KorisnickiServis2.scheduler;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Scheduler {


    private ReservationService reservationService;

    public Scheduler(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Scheduled(fixedDelay = 10000, initialDelay = 0)
    void scheduleTask()
    {
        List<Reservation> lista=reservationService.findAll();
        Date date=new Date();

        for(Reservation r:lista)
        {

            if(((r.getDate_from().getTime()-date.getTime()) / (1000 * 60 * 60))% 24 < 3 && !r.isResent())
            {
                r.setResent(true);
                reservationService.sendScheduledNotification(r);
            }
        }
    }
}
