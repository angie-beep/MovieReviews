package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ReviewEntity;

public class ReviewDaoImpl extends BaseDao implements ReviewDao {

    @Override
    public void create(ReviewEntity review) {
        beginTransaction();
        if (review.getId() == null) {
            em.persist(review);
        } else {
            em.merge(review);
        }
        commitTransaction();
    }

    @Override
    public ReviewEntity read(long id) {
        return em.find(ReviewEntity.class, id);
    }

    @Override
    public void update(ReviewEntity reviewEntity) {
        beginTransaction();
        em.merge(reviewEntity);
        commitTransaction();
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        ReviewEntity review = em.find(ReviewEntity.class, id);
        if (review != null) {
            em.remove(review);
        }
        commitTransaction();
    }
}
