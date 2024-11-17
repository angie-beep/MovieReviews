package de.moviereview.domain.model;

import de.moviereview.infrastructure.persistence.entity.Review;
import de.moviereview.infrastructure.persistence.entity.Watchlist;

import java.util.List;

public class User {

    private Long id;
    private String username;
    private String email;
    private boolean notificationsEnabled;
    private Watchlist watchlist;
    private List<Review> reviews;
}
