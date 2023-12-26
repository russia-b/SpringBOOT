package com.example.moviespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MoviesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMoviesById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindMoviesByTitle() throws Exception {
        String title = "Новый";
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/find")
                        .param("title", title)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .content("{ \"title\": \"Новый\", \"genre\": \"Фильм\", \"yearOfPost\": \"Новый\", \"score\": \"Счет\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMovies() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.put("/movies/" + id)
                        .content("{ \"title\": \"Обновленный\", \"genre\": \"Фильм\", \"yearOfPost\": \"Обновленный\", \"score\": \"Счет\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMovies() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/movies/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}