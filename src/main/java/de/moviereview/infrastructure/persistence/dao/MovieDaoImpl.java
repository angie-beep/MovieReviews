package de.moviereview.infrastructure.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;

public class MovieDaoImpl implements MovieDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void create(MovieEntity movie) {
        em.getTransaction().begin();
        if (movie.getId() == null) {
            em.persist(movie);
        } else {
            movie = em.merge(movie);
        }
        em.getTransaction().commit();

    }
    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        MovieEntity movie = em.find(MovieEntity.class, id);
        if (movie != null) {
            em.remove(movie);
        }
        em.getTransaction().commit();
    }
    @Override
    public MovieEntity read(long id) {
        final MovieEntity result = em.find(MovieEntity.class, id);
        return result;
    }
    @Override
    public void update (MovieEntity movieEntity){

    }
    public void close() {
        em.close();
        emf.close();
    }
}
