package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.UserEntity;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public void create(UserEntity user) {
        beginTransaction();
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        commitTransaction();
    }

    @Override
    public UserEntity read(long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        UserEntity user = em.find(UserEntity.class, id);
        if (user != null) {
            em.remove(user);
        }
        commitTransaction();
    }
}
