package com.example.movie.Service;

import com.example.movie.Model.Movie;
import com.example.movie.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;
    public List<Movie> allMovie(){
        return repository.findAll();
    }

    public Optional<Movie> findById(ObjectId id){
        return repository.findById(id);
    }

    public Optional<Movie> findByImdb(String imdb){
        return repository.findMovieByImdbId(imdb);
    }
}
