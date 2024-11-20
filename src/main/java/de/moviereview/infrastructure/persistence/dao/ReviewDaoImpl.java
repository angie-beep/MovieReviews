package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ReviewEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReviewDaoImpl implements ReviewDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public void create(ReviewEntity review) {
        em.getTransaction().begin();
        if (review.getId() == null) {
            em.persist(review);
        } else {
            review = em.merge(review);
        }
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        ReviewEntity review = em.find(ReviewEntity.class, id);
        if (review != null) {
            em.remove(review);
        }
        em.getTransaction().commit();
    }

    public ReviewEntity read(long id) {
        final ReviewEntity result = em.find(ReviewEntity.class, id);
        return result;
    }

    public void update(ReviewEntity review){

    }

    public void close() {
        em.close();
        emf.close();
    }
}

