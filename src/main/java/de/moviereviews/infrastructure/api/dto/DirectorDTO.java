package de.moviereviews.infrastructure.api.dto;

import java.util.Set;

public class DirectorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthday; // Format "YYYY-MM-DD"
    private String heritage;

    private Set<MovieDTO> movies;

    public DirectorDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getHeritage() {
        return heritage;
    }
    public void setHeritage(String heritage) {
        this.heritage = heritage;
    }
    public Set<MovieDTO> getMovies() { return this.movies; }
    public void setMovies ( Set<MovieDTO> movies ) {this.movies = movies; }
}
