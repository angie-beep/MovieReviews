package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Movie;

import java.util.Set;

public class Watchlist {

    private Long id;
    private boolean isPublic;
    private User user;
    private Set<Movie> movies;
}
