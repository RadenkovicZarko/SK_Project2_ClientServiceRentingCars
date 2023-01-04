package com.komponente.KorisnickiServis2.controller;

import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.mapper.ReviewMapper;
import com.komponente.KorisnickiServis2.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;
    private ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping("/addReview")
    public ResponseEntity<ReviewDto> addReview(@RequestBody()ReviewCreateDto reviewCreateDto) {
        return new ResponseEntity<>(reviewService.addReview(reviewCreateDto), HttpStatus.OK);
    }

    @PostMapping("/findReviews")
    public ResponseEntity<List<ReviewTableDto>> findAllReviews(@RequestBody()ReviewSearchDto reviewSearchDto)
    {
        return new ResponseEntity<>(reviewService.findAllReviewForSearchParameter(reviewSearchDto),HttpStatus.OK);
    }

    @PostMapping("/changeReview")
    public ResponseEntity<ReviewDto> changeReview(@RequestBody()ChangeReviewDto changeReviewDto)
    {
        return new ResponseEntity<>(reviewService.changeReview(changeReviewDto),HttpStatus.OK);
    }

    @PostMapping("/deleteReview")
    public ResponseEntity<DeleteReviewDto> deleteReview(@RequestBody()DeleteReviewDto deleteReviewDto)
    {
        return new ResponseEntity<>(reviewService.deleteReview(deleteReviewDto),HttpStatus.OK);
    }
}
