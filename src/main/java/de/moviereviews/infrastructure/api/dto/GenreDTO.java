package de.moviereviews.infrastructure.api.dto;

import java.util.Set;

public class GenreDTO {
    private Long id;
    private String name; // Anstelle von "genre" als Attributname
    private Set<MovieDTO> movies;

    public GenreDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<MovieDTO> getMovies() { return this.movies; }
    public void setMovies ( Set<MovieDTO> movies ) {this.movies = movies; }
}
