package de.moviereviews.infrastructure.api.dto;

import java.util.List;

public class WatchlistDTO {
    private Long id;
    private Boolean isPublic;
    private UserDTO user;
    private List<MovieDTO> movies;

    public WatchlistDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getIsPublic() {
        return isPublic;
    }
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
    public UserDTO getUser() {
        return user;
    }
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public List<MovieDTO> getMovies() {
        return movies;
    }
    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
