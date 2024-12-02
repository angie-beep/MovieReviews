package de.moviereview.infrastructure.persistence.repository;
import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.persistence.entity.ReviewEntity;
import java.util.concurrent.atomic.AtomicLong;
import com.github.javafaker.Faker;

import java.util.*;
public class ReviewRepository {
    private final Map<Long, Review> reviewStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create or update a review
    public Review save(Review review) {
        if (review.getId() == null) {
            review.setId(idGenerator.getAndIncrement());
        }
        reviewStorage.put(review.getId(), review);
        return review;
    }

    // Find a review by ID
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(reviewStorage.get(id));
    }

    // Get all reviews
    public List<Review> findAll() {
        return new ArrayList<>(reviewStorage.values());
    }

    // Delete a review by ID
    public boolean deleteById(Long id) {
        return reviewStorage.remove(id) != null;
    }

    // Check if a review exists by ID
    public boolean existsById(Long id) {
        return reviewStorage.containsKey(id);
    }
}
