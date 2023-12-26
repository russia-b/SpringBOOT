package com.example.moviespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MoviesServiceTests {

	@Autowired
	private MoviesService moviesService;

	@MockBean
	private MoviesRepository moviesRepository;

	@Test
	public void testGetAllMovies() {
		List<Movies> moviess = new ArrayList<>();
		moviess.add(new Movies("Зеленая миля", "Драма", "1999", "9.2"));
		moviess.add(new Movies("1+1", "Драма", "2011", "9.0"));

		when(moviesRepository.findAll()).thenReturn(moviess);

		List<Movies> retrievedMovies = moviesService.getAllMovies();
		assertEquals(2, retrievedMovies.size(), "Expected 2 movies");
		System.out.println("Retrieved movies: " + retrievedMovies);
	}

	@Test
	public void testGetMoviesById() {
		Long id = 1L;
		Movies movies = new Movies("Интерстеллар", "Фантастика", "2014", "8.9");
		movies.setId(id);

		when(moviesRepository.findById(id)).thenReturn(Optional.of(movies));

		assertEquals(movies, moviesService.getMoviesById(id).orElse(null));
	}

	@Test
	public void testAddMovies() {
		Movies movies = new Movies("Шрэк", "Мультфильм", "2001", "8.8");

		moviesService.addMovies(movies);

		verify(moviesRepository, times(1)).save(movies);
	}

	@Test
	public void testUpdateMovies() {
		Long id = 1L;
		Movies movies = new Movies("Изменено", "Изменено", "Изменено", "1");
		movies.setId(id);

		moviesService.updateMovies(movies);

		verify(moviesRepository, times(1)).save(movies);
	}

	@Test
	public void testDeleteMovies() {
		Long id = 1L;

		moviesService.deleteMovies(id);

		verify(moviesRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindMoviessByTitle() {
		String title = "1+1";
		List<Movies> movies = new ArrayList<>();
		movies.add(new Movies("Унесенные призраками", "Аниме", "2001", "8.9"));

		when(moviesRepository.findByTitleIgnoreCase(title)).thenReturn(movies);

		assertEquals(1, moviesService.findMoviesByTitle(title).size());
	}
}
