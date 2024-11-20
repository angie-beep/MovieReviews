package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDaoImpl implements UserDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public void create(UserEntity user) {
        em.getTransaction().begin();
        if (user.getId() == null) {
            em.persist(user);
        } else {
            user = em.merge(user);
        }
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        UserEntity user = em.find(UserEntity.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
    }

    public UserEntity read(long id) {
        final UserEntity result = em.find(UserEntity.class, id);
        return result;
    }

    public void update(UserEntity userEntity){

    }

   // public void updateUsername(String name);
   // public void updateEmail(String email);
    //public void updateNotificaations();

    public void close() {
        em.close();
        emf.close();
    }
}
