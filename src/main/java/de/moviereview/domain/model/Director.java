package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Movie;
import java.util.Set;
import java.time.LocalDate;
import java.util.List;

public class Director {
    private Long id;

    private String name;
    private LocalDate birthday;
    private String heritage;
    private Set<Movie> movies;

    public Director(){

    }

}
