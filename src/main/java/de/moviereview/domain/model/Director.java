package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Movie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Director {

    private Long id;
    private String name;
    private LocalDate birthday;
    private String heritage;
    private Set<Movie> movies;

    public Director(String name, LocalDate birthday, String heritage, Set<Movie> movies) {
        this.name = name;
        this.birthday = birthday;
        this.heritage = heritage;
        this.movies = movies;
    }

    public Director() {

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHeritage() {
        return heritage;
    }

    public void setHeritage(String heritage) {
        this.heritage = heritage;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getTop3Movies() {
        // Placeholder: Returning an empty list for now
        return new ArrayList<>();
    }
}
