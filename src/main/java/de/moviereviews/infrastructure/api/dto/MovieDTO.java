package de.moviereviews.infrastructure.api.dto;

import de.moviereviews.domain.model.Genre;

import java.util.HashSet;
import java.util.Set;

public class MovieDTO {
    private Long id;
    private String title;
    private Set<GenreDTO> genres;

    private Set<DirectorDTO> directors;
    private String publishingDate; // Als String, evtl. formatiert (z. B. "YYYY-MM-DD")
    private String summary;
    private String trailer;
    private Float overallRating;
    private Integer length;
    private String originalLanguage;



    private Set<ReviewDTO> reviews;



    private Set<ActorDTO> actors;


    // Standard-Konstruktor
    public MovieDTO() {
        this.genres = new HashSet<>();
        this.directors = new HashSet<>();
        this.reviews = new HashSet<>();
        this.actors = new HashSet<>();
    }

    // Getter und Setter
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
    public Set<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreDTO> genres) {
        this.genres = genres;
    }

    public Set<DirectorDTO> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<DirectorDTO> directors) {
        this.directors = directors;
    }

    public Set<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewDTO> reviews) {
        this.reviews = reviews;
    }
    public Set<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(Set<ActorDTO> actors) {
        this.actors = actors;
    }

    public String getPublishingDate() {
        return publishingDate;
    }
    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
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
    public Float getOverallRating() {
        return overallRating;
    }
    public void setOverallRating(Float rating) {
        this.overallRating = rating;
    }
    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
}

