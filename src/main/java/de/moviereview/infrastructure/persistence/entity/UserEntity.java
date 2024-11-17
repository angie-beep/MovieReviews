package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private boolean notificationsEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "watchlist_id")
    private WatchlistEntity watchlist;

    @OneToMany(cascade = CascadeType.ALL)/*(mappedBy = "users")*/
    private Set<ReviewEntity> reviews;

    public UserEntity(String username, String email, boolean notificationsEnabled){
        this.username = username;
        this.email = email;
        this.notificationsEnabled = notificationsEnabled;
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public WatchlistEntity getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(WatchlistEntity watchlist) {
        this.watchlist = watchlist;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
