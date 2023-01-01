package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.ReviewMapper;
import com.komponente.KorisnickiServis2.repository.ReviewRepository;
import com.komponente.KorisnickiServis2.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    ReviewMapper reviewMapper;


    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewDto> findAllReviewForSearchParameter(ReviewSearchDto reviewSearchDto) {
        List<Review> recenzijeZaGrad=new ArrayList<>();
        if(!reviewSearchDto.getCity().isEmpty())
            recenzijeZaGrad=reviewRepository.findAllReviewForCity(reviewSearchDto.getCity()).orElseThrow(() -> new NotFoundException(String
                    .format("There is no such cars")));

        List<Review> recenzijeZaCompanyName=new ArrayList<>();
        if(!reviewSearchDto.getCompanyName().isEmpty())
            recenzijeZaCompanyName=reviewRepository.findAllReviewForCompany(reviewSearchDto.getCompanyName()).orElseThrow(() -> new NotFoundException(String
                    .format("There is no such cars")));

        List<Review> recenzije=new ArrayList<>();

        if(!reviewSearchDto.getCity().isEmpty() && !reviewSearchDto.getCompanyName().isEmpty())
        {
            recenzije = recenzijeZaGrad.stream()
                    .filter(recenzijeZaCompanyName::contains).collect(toList());
        }
        else if(!reviewSearchDto.getCity().isEmpty())
        {
            recenzije = recenzijeZaGrad;
        }
        else if(!reviewSearchDto.getCompanyName().isEmpty())
        {
            recenzije =recenzijeZaCompanyName;
        }

        if(reviewSearchDto.getCity().isEmpty() && reviewSearchDto.getCompanyName().isEmpty() )
            recenzije=reviewRepository.findAll();

        List<ReviewDto> list=new ArrayList<>();

        for(Review r:recenzije)
            list.add(reviewMapper.reviewToReviewDto(r));
        return list;
    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        Review review=new Review(reviewDto.getUser_id(),reviewDto.getDescription(),reviewDto.getCompany(),reviewDto.getRating());
        reviewRepository.save(review);
        return reviewDto;
    }

    @Override
    public DeleteReviewDto deleteReview(DeleteReviewDto deleteReviewDto) {
        Review review=new Review(deleteReviewDto.getId(),deleteReviewDto.getUser_id(),deleteReviewDto.getDescription(),deleteReviewDto.getCompany(),deleteReviewDto.getRating());
        reviewRepository.delete(review);
        return deleteReviewDto;
    }


    @Override
    public ReviewDto changeReview(ChangeReviewDto changeReviewDto) {
        Review review= reviewRepository.getOne(changeReviewDto.getId());
        review.setDescription(changeReviewDto.getDescription());
        review.setRating(changeReviewDto.getRating());
        reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }
}
