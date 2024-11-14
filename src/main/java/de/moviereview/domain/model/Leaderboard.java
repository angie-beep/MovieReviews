
package de.moviereview.domain.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String genre;

    @ManyToMany
    private List<Movie> top10Movies;

    // Constructors
    public Leaderboard() {

    }

    public Leaderboard(String genre, List<Movie> top10Movies) {
        this.genre = genre;
        this.top10Movies = top10Movies;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Movie> getTop10Movies() {
        return top10Movies;
    }

    public void setTop10MovieIds(List<Movie> top10Movies) {
        this.top10Movies = top10Movies;
    }
}
