package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.DirectorEntity;

public class DirectorDaoImpl extends BaseDao implements DirectorDao {

    @Override
    public void create(DirectorEntity director) {
        beginTransaction();
        if (director.getId() == null) {
            em.persist(director);
        } else {
            em.merge(director);
        }
        commitTransaction();
    }

    @Override
    public DirectorEntity read(long id) {
        return em.find(DirectorEntity.class, id);
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        DirectorEntity director = em.find(DirectorEntity.class, id);
        if (director != null) {
            em.remove(director);
        }
        commitTransaction();
    }
}
