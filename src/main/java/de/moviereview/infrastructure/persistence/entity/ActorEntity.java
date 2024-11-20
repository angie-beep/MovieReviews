package de.moviereview.infrastructure.persistence.entity;

//Represents the database structure for storing actor data.

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "actors")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String lastname;
    private String firstname;
    private LocalDate birthday;
    private String heritage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "actor_movie",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<MovieEntity> movies;

    public ActorEntity() {

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

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }

    public List<MovieEntity> getTop3Movies() {
        // Placeholder: Returning an empty list for now
        return new ArrayList<>();
    }
}
