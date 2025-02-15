package de.moviereviews.infrastructure.api.dto;

public class ReviewDTO {
    private Long id;

    private MovieDTO movie;


    private UserDTO user;
    private Integer rating;
    private String comment;
    private String createdAt; // Format z. B. ISO-8601
    private String updatedAt; // Format z. B. ISO-8601

    public ReviewDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }


    public Integer getStarRating() {
        return rating;
    }
    public void setStarRating(Integer rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
