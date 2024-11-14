package de.moviereview.domain.model;

import java.time.LocalDateTime;

public class Review {

    private Long id;
    private int starRating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User user;
    private Movie movie;
}
