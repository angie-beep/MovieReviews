package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ActorDaoImpl implements ActorDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public ActorEntity read(long id) {
        return em.find(ActorEntity.class, id);
    }

    @Override
    public void create(ActorEntity actor) {
        em.getTransaction().begin();
        if (actor.getId() == null) {
            em.persist(actor); // New actor
        } else {
            em.merge(actor); // Update existing actor
        }
        em.getTransaction().commit();
    }

    @Override
    public void updateFirstname(String firstname) {
        em.getTransaction().begin();
        em.createQuery("UPDATE ActorEntity a SET a.firstname = :firstname")
                .setParameter("firstname", firstname)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void updateLastname(String lastname) {
        em.getTransaction().begin();
        em.createQuery("UPDATE ActorEntity a SET a.lastname = :lastname")
                .setParameter("lastname", lastname)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        ActorEntity actor = em.find(ActorEntity.class, id);
        if (actor != null) {
            em.remove(actor);
        }
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
