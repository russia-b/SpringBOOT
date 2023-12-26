package com.example.moviespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movies getMoviesById(@PathVariable Long id) {
        return moviesService.getMoviesById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Movies> findMoviesByTitle(@RequestParam(name="title") String title) {
        return moviesService.findMoviesByTitle(title);
    }
    @GetMapping("/findby") //Поиск по фрагменту
    public List<Movies> findMoviesByTitleFragment(@RequestParam(name="title") String Title) {
        return moviesService.findMoviesByTitleFragment(Title);
    }

    @PostMapping
    public void addMovies(@RequestBody Movies movies) {
        moviesService.addMovies(movies);
    }

    @PutMapping("/{id}")
    public void updateMovies(@PathVariable Long id, @RequestBody Movies movies) {
        movies.setId(id);
        moviesService.updateMovies(movies);
    }

    @DeleteMapping("/{id}")
    public void deleteMovies(
            @PathVariable Long id) {
        moviesService.deleteMovies(id);
    }
}