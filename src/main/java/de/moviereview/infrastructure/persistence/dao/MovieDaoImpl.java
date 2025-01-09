package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;

public class MovieDaoImpl extends BaseDao implements MovieDao {

    @Override
    public void create(MovieEntity movie) {
        beginTransaction();
        if (movie.getId() == null) {
            em.persist(movie);
        } else {
            em.merge(movie);
        }
        commitTransaction();
    }

    @Override
    public MovieEntity read(long id) {
        return em.find(MovieEntity.class, id);
    }

    @Override
    public void update(MovieEntity movieEntity) {
        beginTransaction();
        em.merge(movieEntity);
        commitTransaction();
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        MovieEntity movie = em.find(MovieEntity.class, id);
        if (movie != null) {
            em.remove(movie);
        }
        commitTransaction();
    }
}
