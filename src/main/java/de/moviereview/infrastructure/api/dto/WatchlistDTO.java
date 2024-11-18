package de.moviereview.infrastructure.api.dto;

import java.util.Set;

public class WatchlistDTO {
    private Long id;
    private boolean isPublic;
    private Long userId;
    private Set<Long> movieIds;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(Set<Long> movieIds) {
        this.movieIds = movieIds;
    }
}
