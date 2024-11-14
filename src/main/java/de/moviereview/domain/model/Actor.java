package de.moviereview.domain.model;
import java.util.List;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String name;
    private LocalDate birthday;
    private String heritage;

    @ManyToMany
    private List<Movie> movies;
    @Transient
    private List<Movie> top3movies;

    public Actor() {

    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getTop3movies() {
        return top3movies;
    }

    public void setTop3movies(List<Movie> top3movies) {
        this.top3movies = top3movies;
    }

}
