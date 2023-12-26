package com.example.moviespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MoviesRepositoryTests {

    @Autowired
    private MoviesRepository moviesRepository;

    @Test
    public void testFindByTitleIgnoreCase() {
        Movies movies = new Movies("Барби", "Комедия", "2023", "8");
        moviesRepository.save(movies);

        List<Movies> retrievedMovies = moviesRepository.findByTitleIgnoreCase("Барби");

        assertEquals(1, retrievedMovies.size(), "Ожидается фильм с указанным названием");
        assertEquals(movies.getGenre(), retrievedMovies.get(0).getGenre());
    }
}