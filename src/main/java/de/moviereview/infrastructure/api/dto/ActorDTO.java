package de.moviereview.infrastructure.api.dto;

//defines how actor data is represented in the API layer
//right now same as actor model but provides a clean separation between the internal domain and the external API contract. Future changes to the model won’t impact the API if DTOs act as a buffer.
//A simplified data transfer object used to transfer actor data between layers.

import java.time.LocalDate;
import java.util.Set;

public class ActorDTO {
    private Long id;
    private String lastname;
    private String firstname;
    private LocalDate birthday;
    private String heritage;
    private Set<Long> movieIds;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
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

    public Set<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(Set<Long> movieIds) {
        this.movieIds = movieIds;
    }
}
