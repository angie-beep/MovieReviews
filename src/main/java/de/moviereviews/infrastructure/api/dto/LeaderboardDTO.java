package de.moviereviews.infrastructure.api.dto;

import java.util.Set;

public class LeaderboardDTO {
    private Long id;
    private String genre;
    private Set<MovieDTO> movies;

    public LeaderboardDTO() {
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
    public Set<MovieDTO> getMovies() { return this.movies; }
    public void setMovies ( Set<MovieDTO> movies ) {this.movies = movies; }
}
