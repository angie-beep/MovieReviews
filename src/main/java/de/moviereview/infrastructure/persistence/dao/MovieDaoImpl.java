package de.moviereview.infrastructure.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;

public class MovieDaoImpl {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public MovieEntity create(MovieEntity movie) {
        em.getTransaction().begin();
        if (movie.getId() == null) {
            em.persist(movie);
        } else {
            movie = em.merge(movie);
        }
        em.getTransaction().commit();
        return movie;
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        MovieEntity movie = em.find(MovieEntity.class, id);
        if (movie != null) {
            em.remove(movie);
        }
        em.getTransaction().commit();
    }

    public MovieEntity read(Long id) {
        final MovieEntity result = em.find(MovieEntity.class, id);
        return result;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
