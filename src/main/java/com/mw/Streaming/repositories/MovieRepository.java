package com.mw.Streaming.repositories;

import com.mw.Streaming.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}
