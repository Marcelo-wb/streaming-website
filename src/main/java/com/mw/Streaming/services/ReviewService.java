package com.mw.Streaming.services;

import com.mw.Streaming.model.Movie;
import com.mw.Streaming.model.Review;
import com.mw.Streaming.repositories.ReviewRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository REPOSITORY;
    private final MongoTemplate template;

    public ReviewService(MongoTemplate template, ReviewRepository repository) {
        this.template = template;
        REPOSITORY = repository;
    }
    public Review CreateReview(String body, String imbdId){
        Review review = REPOSITORY.insert(new Review(body));
        template.update(Movie.class).matching(Criteria.where(imbdId).is(imbdId)).apply(new Update().push("reviewsIds").value(review)).first();
        return review;
    }

}
