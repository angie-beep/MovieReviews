package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;

import java.util.List;

public interface MovieDao {
    void create(MovieEntity movieEntity);

    MovieEntity read(long movieId);

    void update(MovieEntity movieEntity);

    void delete(long movieId);

}
