package de.moviereview.infrastructure.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class BaseDao {
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    protected final EntityManager em = emf.createEntityManager();

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }

    public void rollbackTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}

