package de.moviereview.infrastructure.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.Set;


@Entity
//@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String lastname;
    private String firstname;
    private LocalDate birthday;
    private String heritage;

    @ManyToMany
    /*
    @JoinTable(
        name = "actor_movie",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    */
    private Set<Movie> movies;

    public Actor() {

    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String name) {
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
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

    public List<Movie> getTop3Movies() {
        // Placeholder: Returning an empty list for now
        return new ArrayList<>();
    }
}
