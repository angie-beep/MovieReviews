package de.moviereview.infrastructure.api.dto;

import java.time.LocalDate;
import java.util.Set;

public class MovieDTO {
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
    private Set<Long> actorIds;
    private Set<Long> directorIds;
    private Set<Long> reviewIds;
    private Set<Long> watchlistIds;

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

    public double getOverallRating() {
        return overallRating;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public Set<Long> getActorIds() {
        return actorIds;
    }

    public void setActorIds(Set<Long> actorIds) {
        this.actorIds = actorIds;
    }

    public Set<Long> getDirectorIds() {
        return directorIds;
    }

    public void setDirectorIds(Set<Long> directorIds) {
        this.directorIds = directorIds;
    }

    public Set<Long> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(Set<Long> reviewIds) {
        this.reviewIds = reviewIds;
    }

    public Set<Long> getWatchlistIds() {
        return watchlistIds;
    }

    public void setWatchlistIds(Set<Long> watchlistIds) {
        this.watchlistIds = watchlistIds;
    }
}
