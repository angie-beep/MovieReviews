package de.moviereview.domain.model;

import java.util.Set;

public class Watchlist {

    private Long id;
    private boolean isPublic;
    private User user;
    private Set<Movie> movies;

    public Watchlist(boolean isPublic, User user, Set<Movie> movies){
        this.isPublic = isPublic;
        this.user = user;
        this.movies = movies;
    }

    public Watchlist() {
    }

    public Watchlist(Long id, boolean isPublic, User user, Set<Movie> movies) {
        this.id = id;
        this.isPublic = isPublic;
        this.user = user;
        this.movies = movies;
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
