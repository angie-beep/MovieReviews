package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ReviewEntity;

import java.util.List;

public interface ReviewDao {
    void create(ReviewEntity reviewEntity);

    ReviewEntity read(long reviewId);

    void update(ReviewEntity reviewEntity);

    void delete(long reviewId);
}