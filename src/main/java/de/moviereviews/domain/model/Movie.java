package de.moviereviews.domain.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Movie {

    private Long id;
    private String title;
    private String summary;
    private String trailer;
    private double overallRating;
    private LocalDate publishingDate;
    private int length;
    private String originalLanguage;
    private Set<Actor> actors = new HashSet<>();;
    private Set<Director> directors = new HashSet<>();;
    private Set<Review> reviews = new HashSet<>();;
    private Set<Watchlist> watchlist = new HashSet<>();;
    private Set<Genre> genres = new HashSet<>();;


    public Movie(String title, String summary, String trailer, LocalDate publishingDate, int length, String originalLanguage) {
        this.title = title;
        this.summary = summary;
        this.trailer = trailer;
        this.publishingDate = publishingDate;
        this.length = length;
        this.originalLanguage = originalLanguage;
        this.overallRating = 0.0; //default
        this.genres = new HashSet<>();
    }

    public Movie() {

    }

    public Movie(Long id, String title, String summary, String trailer, double overallRating, LocalDate publishingDate, int length, String originalLanguage, Set<Actor> actors, Set<Director> directors, Set<Review> reviews, Set<Watchlist> watchlist) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.trailer = trailer;
        this.overallRating = overallRating;
        this.publishingDate = publishingDate;
        this.length = length;
        this.originalLanguage = originalLanguage;
        this.actors = actors;
        this.directors = directors;
        this.reviews = reviews;
        this.watchlist = watchlist;
    }

// Getters and Setters

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public float getOverallRating() {
        return (float) overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors (Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Watchlist> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Set<Watchlist> watchlist) {
        this.watchlist = watchlist;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre){};
    public void removeGenre(Genre genre){};
}


