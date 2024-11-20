package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.DirectorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DirectorDaoImpl implements DirectorDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void create(DirectorEntity director) {
        em.getTransaction().begin();
        if (director.getId() == null) {
            em.persist(director);
        } else {
            director = em.merge(director);
        }
        em.getTransaction().commit();

    }
    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        DirectorEntity director = em.find(DirectorEntity.class, id);
        if (director != null) {
            em.remove(director);
        }
        em.getTransaction().commit();
    }
    @Override
    public DirectorEntity read(long id) {
        final DirectorEntity result = em.find(DirectorEntity.class, id);
        return result;
    }
    @Override
    public void update (DirectorEntity directorEntity){
    };

    public void close() {
        em.close();
        emf.close();
    }
}
