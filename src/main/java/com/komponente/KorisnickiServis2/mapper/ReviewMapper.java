package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReviewCreateDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review reviewCreateDtoToReview(ReviewCreateDto reviewCreateDto)
    {
        Review review=new Review();
        review.setRating(reviewCreateDto.getRating());
        review.setUserId(reviewCreateDto.getRating());
        review.setDescription(reviewCreateDto.getDescription());
        review.setId_company(reviewCreateDto.getCompany());
        return review;
    }
}
