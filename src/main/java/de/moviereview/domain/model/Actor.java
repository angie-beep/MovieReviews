package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Movie;

import java.time.LocalDate;
import java.util.Set;

public class Actor {
    public Long id;

    private String name;
    private LocalDate birthday;
    private String heritage;
    private Set<Movie> movies;

    public Actor() {

    }
}
