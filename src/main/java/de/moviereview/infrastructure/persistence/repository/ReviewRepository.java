package de.moviereview.infrastructure.persistence.repository;


import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.persistence.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    // Find reviews by movie ID
    List<ReviewEntity> findByMovie_Id(Long movieId);

    // Find reviews by user ID
    List<ReviewEntity> findByUser_Id(Long userId);

    List<ReviewEntity> findByMovieId(Long movieId);

    List<ReviewEntity> findByUserId(Long userId);
}
