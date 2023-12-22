package com.mw.Streaming.services;

import com.mw.Streaming.model.Movie;
import com.mw.Streaming.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository REPOSITORY;
    public MovieService(MovieRepository repository) {
        REPOSITORY = repository;
    }

    public List<Movie> findAll(){
        return REPOSITORY.findAll();
    }

    public Optional<Movie> findById(ObjectId id){
        return REPOSITORY.findById(id);
    }
}
