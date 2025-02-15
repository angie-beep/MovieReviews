package de.moviereviews.infrastructure.api.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private WatchlistDTO watchlist;

    public UserDTO() {
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
    public WatchlistDTO getWatchlist() {
        return watchlist;
    }
    public void setWatchlist(WatchlistDTO watchlist) {
        this.watchlist = watchlist;
    }
}
