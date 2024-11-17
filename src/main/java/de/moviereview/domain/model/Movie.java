package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Review;
import de.moviereview.infrastructure.persistence.entity.Watchlist;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
public class Movie {

    private Long id;
    private String title;
    private String summary;
    private String trailer;
    private double overallRating;
    private LocalDate publishingDate;
    private String genre;
    private Integer rank;
    private int length;
    private String originalLanguage;
    private Set<Actor> actors;
    private Set<Director> directors;
    private List<Review> reviews;
    private Set<Watchlist> watchlist;
}
