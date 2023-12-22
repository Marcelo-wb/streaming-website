package com.mw.Streaming.Controllers;

import com.mw.Streaming.model.Review;
import com.mw.Streaming.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService SERVICE;
    public ReviewController(ReviewService service) {
        SERVICE = service;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(SERVICE.CreateReview(payload.get("body"), payload.get("imbdId")), HttpStatus.CREATED);
    }

}
