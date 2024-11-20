package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "watchlists")
public class WatchlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_public")
    private boolean isPublic;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "watchlist_movie",
        joinColumns = @JoinColumn(name = "watchlist_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<MovieEntity> movies;

    public WatchlistEntity(boolean isPublic, UserEntity user, Set<MovieEntity> movies){
        this.isPublic = isPublic;
        this.user = user;
        this.movies = movies;
    }

    public WatchlistEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }
}
