package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.*;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAllReviewForSearchParameter(ReviewSearchDto reviewSearchDto);
    ReviewDto addReview(ReviewDto reviewDto);
    DeleteReviewDto deleteReview(DeleteReviewDto deletereviewDto);
    ChangeReviewDto changeReview(ChangeReviewDto changeReviewDto);

}
