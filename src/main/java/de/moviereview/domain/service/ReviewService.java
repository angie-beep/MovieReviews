package de.moviereview.domain.service;

public class ReviewService {
/*
    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;

    // Konstruktor zur Initialisierung der Repositorys
    public ReviewService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    // Methode zum Aktualisieren der Durchschnittsbewertung
    public void updateAverageRating(Long movieId) {
        Movie movie = movieRepository.findById(movieId);
        if (movie != null) {
            List<Review> reviews = reviewRepository.findByMovieId(movieId);
            double averageRating = reviews.stream().mapToDouble(Review::getStarRating).average().orElse(0.0);
            movie.setOverallRating(averageRating);
            movieRepository.save(movie);
        } else {
            System.out.println("Film mit der angegebenen ID wurde nicht gefunden.");
        }
    }*/
}
