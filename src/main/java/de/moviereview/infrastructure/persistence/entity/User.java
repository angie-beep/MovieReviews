package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private boolean notificationsEnabled;

    @OneToOne
    //@JoinColumn(name = "watchlist_id")
    private Watchlist watchlist;

    @OneToMany/*(mappedBy = "users")*/
    private Set<Review> reviews;

    public User(String username, String email, boolean notificationsEnabled){
        this.username = username;
        this.email = email;
        this.notificationsEnabled = notificationsEnabled;
    }

    public User() {

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

    public Watchlist getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Watchlist watchlist) {
        this.watchlist = watchlist;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
