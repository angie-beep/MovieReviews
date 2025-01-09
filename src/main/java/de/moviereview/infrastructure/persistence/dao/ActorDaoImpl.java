package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;

public class ActorDaoImpl extends BaseDao implements ActorDao {

    @Override
    public ActorEntity read(long id) {
        return em.find(ActorEntity.class, id);
    }

    @Override
    public void create(ActorEntity actor) {
        beginTransaction();
        if (actor.getId() == null) {
            em.persist(actor);
        } else {
            em.merge(actor);
        }
        commitTransaction();
    }

    @Override
    public void updateFirstname(String firstname) {
        beginTransaction();
        em.createQuery("UPDATE ActorEntity a SET a.firstname = :firstname")
                .setParameter("firstname", firstname)
                .executeUpdate();
        commitTransaction();
    }

    @Override
    public void updateLastname(String lastname) {
        beginTransaction();
        em.createQuery("UPDATE ActorEntity a SET a.lastname = :lastname")
                .setParameter("lastname", lastname)
                .executeUpdate();
        commitTransaction();
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        ActorEntity actor = em.find(ActorEntity.class, id);
        if (actor != null) {
            em.remove(actor);
        }
        commitTransaction();
    }
}

