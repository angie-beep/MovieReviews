package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
//@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(cascade = CascadeType.ALL)/*(mappedBy = "movies")*/
    private Set<ActorEntity> actors;
    @ManyToMany(cascade = CascadeType.ALL)/*(mappedBy = "movies")*/
    private Set<DirectorEntity> directors;
    @OneToMany(cascade = CascadeType.ALL)/*(mappedBy = "movies")*/
    private Set<ReviewEntity> reviews;
    @ManyToMany(cascade = CascadeType.ALL)/*(mappedBy = "movies")*/
    private Set<WatchlistEntity> watchlist;

    public MovieEntity(String title, String summary, String trailer, LocalDate publishingDate, String genre, int length, String originalLanguage) {
        this.title = title;
        this.summary = summary;
        this.trailer = trailer;
        this.publishingDate = publishingDate;
        this.genre = genre;
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


