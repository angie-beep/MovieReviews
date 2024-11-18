package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.entity.UserEntity;
import java.time.LocalDateTime;

public class Review {

    private Long id;
    private UserEntity user;
    private MovieEntity movie;
    private int starRating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, getters, and setters

    public Review() {

    }

    public Review(UserEntity user, MovieEntity movie, int starRating, String comment) {
        this.user = user;
        this.movie = movie;
        this.starRating = starRating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
    }

    public Review(Long id, UserEntity user, MovieEntity movie, int starRating, String comment, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
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
