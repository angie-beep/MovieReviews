package de.moviereviews.infrastructure.persistence.repository;

import de.moviereviews.infrastructure.persistence.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByUserId(Long userId);
    List<ReviewEntity> findByMovieId(Long movieId);
}

