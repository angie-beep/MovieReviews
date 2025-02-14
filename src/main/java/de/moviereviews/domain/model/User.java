package de.moviereviews.domain.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String username;
    private String email;
    private boolean notificationsEnabled;
    private Watchlist watchlist;
    private Set<Review> reviews = new HashSet<>();;

    public User(String username, String email, boolean notificationsEnabled){
        this.username = username;
        this.email = email;
        this.notificationsEnabled = notificationsEnabled;
    }

    public User() {

    }

    public User(Long id, String username, String email, boolean notificationsEnabled, Watchlist watchlist, Set<Review> reviews) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.notificationsEnabled = notificationsEnabled;
        this.watchlist = watchlist;
        this.reviews = reviews;
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
