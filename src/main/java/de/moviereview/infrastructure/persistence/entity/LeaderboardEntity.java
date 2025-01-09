package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboards")
public class LeaderboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genre;

    // Constructors
    public LeaderboardEntity() {

    }

    public LeaderboardEntity(String genre) {
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
