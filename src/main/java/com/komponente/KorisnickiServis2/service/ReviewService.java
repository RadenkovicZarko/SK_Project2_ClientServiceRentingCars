package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.*;

import java.util.List;

public interface ReviewService {

    List<ReviewTableDto> findAllReviewForSearchParameter(ReviewSearchDto reviewSearchDto);
    ReviewDto addReview(ReviewCreateDto reviewCreateDto);
    DeleteReviewDto deleteReview(DeleteReviewDto deletereviewDto);
    ReviewDto changeReview(ChangeReviewDto changeReviewDto);

}
