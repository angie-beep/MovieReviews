package de.moviereviews.domain.model;

import de.moviereviews.domain.service.MovieRankingService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Director {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private String heritage;
    private Set<Movie> movies = new HashSet<>();;

    public Director(String lastName, String firstName, LocalDate birthday, String heritage, Set<Movie> movies) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.heritage = heritage;
        this.movies = movies;
    }

    public Director() {

    }

    public Director(Long id, String lastName, String firstName, LocalDate birthday, String heritage, Set<Movie> movies) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.heritage = heritage;
        this.movies = movies;
    }

    public Director(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHeritage() {
        return heritage;
    }

    public void setHeritage(String heritage) {
        this.heritage = heritage;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getTop3Movies(MovieRankingService movieRankingService) {
        return movieRankingService.getTop3MoviesForDirector(this);
    }
}
