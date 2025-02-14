package de.moviereviews.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Genre {

    private Long id;
    private String genre;
    private Set<Movie> movies = new HashSet<>();;

    public Genre(){}

    public Genre(Long id, String genre, Set<Movie> movies) {
        this.id = id;
        this.genre = genre;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
