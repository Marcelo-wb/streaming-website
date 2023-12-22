package com.mw.Streaming.Controllers;

import com.mw.Streaming.model.Movie;
import com.mw.Streaming.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService SERVICE;

    public MovieController(MovieService service) {
        SERVICE = service;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> findAll() {
        return new ResponseEntity<>(SERVICE.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable ObjectId id){
        return new ResponseEntity<>(SERVICE.findById(id), HttpStatus.OK);
    }

}
