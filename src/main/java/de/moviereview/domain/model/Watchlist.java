package de.moviereview.domain.model;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.model.User;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean isPublic;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Movie> movies;

    public Watchlist(boolean isPublic, User user, List<Movie> movies){
        this.isPublic = isPublic;
        this.user = user;
        this.movies = movies;
    }

    public Watchlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
