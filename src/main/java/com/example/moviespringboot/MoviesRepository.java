package com.example.moviespringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    public List<Movies> findByTitleIgnoreCase (String title);
    public List<Movies> findByTitleContaining (String title);
}