package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ActorDaoImpl {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public ActorEntity create(ActorEntity actor) {
        em.getTransaction().begin();
        if (actor.getId() == null) {
            em.persist(actor);
        } else {
            actor = em.merge(actor);
        }
        em.getTransaction().commit();
        return actor;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        ActorEntity actor = em.find(ActorEntity.class, id);
        if (actor != null) {
            em.remove(actor);
        }
        em.getTransaction().commit();
    }

    public ActorEntity read(Long id) {
        final ActorEntity result = em.find(ActorEntity.class, id);
        return result;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
