package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "watchlists")
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isPublic;

    @OneToOne
    //@JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    /*
    @JoinTable(
        name = "watchlist_movie",
        joinColumns = @JoinColumn(name = "watchlist_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    */
    private Set<Movie> movies;

    public Watchlist(boolean isPublic, User user, Set<Movie> movies){
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
