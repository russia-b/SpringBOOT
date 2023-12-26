package com.example.moviespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> getMoviesById(Long id) {
        return moviesRepository.findById(id);
    }

    public void addMovies(Movies movies) {
        moviesRepository.save(movies);
    }

    public void updateMovies(Movies movies) {
        moviesRepository.save(movies);
    }

    public void deleteMovies(Long id) {
        moviesRepository.deleteById(id);
    }

    public List<Movies> findMoviesByTitle(String Title) {
        return moviesRepository.findByTitleIgnoreCase(Title);
    }

    public List<Movies> findMoviesByTitleFragment(String Title) {
        return moviesRepository.findByTitleContaining(Title);
    }
}