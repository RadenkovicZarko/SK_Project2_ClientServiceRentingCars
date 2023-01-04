package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.dto.ReviewCreateDto;
import com.komponente.KorisnickiServis2.dto.ReviewDto;
import com.komponente.KorisnickiServis2.dto.ReviewTableDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {



    public ReviewDto reviewToReviewDto(Review review)
    {
        ReviewDto reviewDto=new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setRating(review.getRating());
        reviewDto.setDescription(review.getDescription());
        reviewDto.setUser_id(review.getUserId());
        reviewDto.setId_company(review.getCompany().getId());
        return reviewDto;
    }

    public ReviewTableDto reviewToReviewTableDto(Review review)
    {
        ReviewTableDto reviewDto=new ReviewTableDto();
        reviewDto.setId(review.getId());
        reviewDto.setRating(review.getRating());
        reviewDto.setDescription(review.getDescription());
        reviewDto.setUser_id(review.getUserId());
        reviewDto.setCompanyName(review.getCompany().getName());
        return reviewDto;
    }


}
