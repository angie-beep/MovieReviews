package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.entity.UserEntity;
import java.time.LocalDateTime;

public class Review {

    private Long id;
    private User user;
    private Movie movie;
    private int starRating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, getters, and setters

    public Review() {

    }

    public Review(User user, Movie movie, int starRating, String comment) {
        this.user = user;
        this.movie = movie;
        this.starRating = starRating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
    }

    public Review(Long id, User user, Movie movie, int starRating, String comment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.starRating = starRating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
