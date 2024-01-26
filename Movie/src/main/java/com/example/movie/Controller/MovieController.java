package com.example.movie.Controller;

import com.example.movie.Model.Movie;
import com.example.movie.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(service.allMovie(), HttpStatus.OK);
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("imdb/{imdb}")
    public ResponseEntity<Optional<Movie>> getMovieByImdb(@PathVariable String imdb){
        return new ResponseEntity<Optional<Movie>>(service.findByImdb(imdb), HttpStatus.OK);
    }
}