package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class WatchlistDaoImpl implements WatchlistDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public WatchlistEntity create(WatchlistEntity watchlist) {
        em.getTransaction().begin();
        if (watchlist.getId() == null) {
            em.persist(watchlist);
        } else {
            watchlist = em.merge(watchlist);
        }
        em.getTransaction().commit();
        return watchlist;
    }

    public void updatePublic(){

    }

    public void addMovie(MovieEntity movie){

    }

    public void delete(Long id) {
        em.getTransaction().begin();
        WatchlistEntity watchlist = em.find(WatchlistEntity.class, id);
        if (watchlist != null) {
            em.remove(watchlist);
        }
        em.getTransaction().commit();
    }

    public WatchlistEntity read(Long id) {
        final WatchlistEntity result = em.find(WatchlistEntity.class, id);
        return result;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
