package de.moviereviews.domain.model;

public class Leaderboard {

    private Long id;
    private String genre;

    private Leaderboard() {

    }

    public Leaderboard(String genre) {
        this.genre = genre;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
