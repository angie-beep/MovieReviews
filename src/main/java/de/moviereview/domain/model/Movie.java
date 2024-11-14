package de.moviereview.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String trailer; // Link to the trailer (z.b. Youtube URL)
    private double overallRating; // Calculated based on reviews
    private LocalDate publishingDate;
    private String genre;
    private Integer rank; // Optional field, can be used for leaderboard
    private int length; // Movie length in minutes
    private String originalLanguage;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;
    @ManyToMany(mappedBy = "movies")
    private List<Director> directors;
    @OneToMany(mappedBy = "movies")
    private List<Review> reviews;
    @ManyToMany(mappedBy = "movies")
    private List<Watchlist> watchlist;

    public Movie(String title, String summary, String trailer, LocalDate publishingDate, String genre, int length, String originalLanguage) {
        this.title = title;
        this.summary = summary;
        this.trailer = trailer;
        this.publishingDate = publishingDate;
        this.genre = genre;
        this.length = length;
        this.originalLanguage = originalLanguage;
        this.overallRating = 0.0; // Set default rating
    }

    public Movie() {

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

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public List<Director> getDirector() {
        return directors;
    }

    public void setDirector(List<Director> directors) {
        this.directors = directors;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}


