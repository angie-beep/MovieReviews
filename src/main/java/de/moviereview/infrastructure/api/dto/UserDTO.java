package de.moviereview.infrastructure.api.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private boolean notificationsEnabled;
    private Long watchlistId;
    private Set<Long> reviewIds;

    // Getters and Setters
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

    public Long getWatchlistId() {
        return watchlistId;
    }

    public void setWatchlistId(Long watchlistId) {
        this.watchlistId = watchlistId;
    }

    public Set<Long> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(Set<Long> reviewIds) {
        this.reviewIds = reviewIds;
    }
}
