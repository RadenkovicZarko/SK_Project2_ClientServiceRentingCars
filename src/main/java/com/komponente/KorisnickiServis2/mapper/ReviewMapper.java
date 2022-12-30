package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review reviewDtoToReview(ReviewDto reviewDto)
    {
        Review review=new Review();
        review.setRating(reviewDto.getRating());
        review.setUserId(reviewDto.getRating());
        review.setDescription(reviewDto.getDescription());
        review.setId_company(reviewDto.getCompany());
        return review;
    }

    public ReviewDto reviewToReviewDto(Review review)
    {
        ReviewDto reviewDto=new ReviewDto();
        reviewDto.setRating(review.getRating());
        reviewDto.setDescription(review.getDescription());
        reviewDto.setUser_id(review.getUserId());
        reviewDto.setCompany(review.getId_company());
        return reviewDto;
    }
}
