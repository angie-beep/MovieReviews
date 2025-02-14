package de.moviereviews.infrastructure.api.dto;

public class UserDTO {
    private Long id;
    private String name;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
