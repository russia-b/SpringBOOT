package com.example.moviespringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String yearOfPost;
    private String score;
    public Movies() {
    }

    public Movies(String title, String genre, String yearOfPost, String score) {
        this.title = title;
        this.genre = genre;
        this.yearOfPost = yearOfPost;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearOfPost() {
        return yearOfPost;
    }

    public void setYearOfPost(String yearOfPost) {
        this.yearOfPost = yearOfPost;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id) &&
                Objects.equals(title, movies.title) &&
                Objects.equals(genre, movies.genre) &&
                Objects.equals(yearOfPost, movies.yearOfPost) &&
                Objects.equals(score, movies.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, yearOfPost, score);
    }
}
