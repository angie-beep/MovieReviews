package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ReviewEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReviewDaoImpl {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public ReviewEntity create(ReviewEntity review) {
        em.getTransaction().begin();
        if (review.getId() == null) {
            em.persist(review);
        } else {
            review = em.merge(review);
        }
        em.getTransaction().commit();
        return review;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        ReviewEntity review = em.find(ReviewEntity.class, id);
        if (review != null) {
            em.remove(review);
        }
        em.getTransaction().commit();
    }

    public ReviewEntity read(Long id) {
        final ReviewEntity result = em.find(ReviewEntity.class, id);
        return result;
    }

    public void close() {
        em.close();
        emf.close();
    }
}

