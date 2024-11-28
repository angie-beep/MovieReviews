package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String trailer;

    @Column(name = "overall_rating")
    private double overallRating;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;

    private int length;

    @Column(name = "original_language")
    private String originalLanguage;

    @ManyToMany(mappedBy = "movies")
    private Set<ActorEntity> actors;
    @ManyToMany(mappedBy = "movies")
    private Set<DirectorEntity> directors;
    @OneToMany(mappedBy = "movies")
    private Set<ReviewEntity> reviews;
    @ManyToMany(mappedBy = "movies")
    private Set<WatchlistEntity> watchlist;
    @ManyToMany(mappedBy = "movies")
    private Set<GenreEntity> genres;

    public MovieEntity(String title, String summary, String trailer, LocalDate publishingDate, int length, String originalLanguage) {
        this.title = title;
        this.summary = summary;
        this.trailer = trailer;
        this.publishingDate = publishingDate;
        this.length = length;
        this.originalLanguage = originalLanguage;
        this.overallRating = 0.0; //default
    }

    public MovieEntity() {

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

    public Set<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(Set<ActorEntity> actors) {
        this.actors = actors;
    }

    public Set<DirectorEntity> getDirector() {
        return directors;
    }

    public void setDirectors (Set<DirectorEntity> directors) {
        this.directors = directors;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public Set<WatchlistEntity> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Set<WatchlistEntity> watchlist) {
        this.watchlist = watchlist;
    }
}


