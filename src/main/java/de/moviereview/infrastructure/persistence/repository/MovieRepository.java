package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    // Find movies by genre
    List<MovieEntity> findByGenres_GenreIgnoreCase(String genre);

    // Find movies by director's last name
    List<MovieEntity> findByDirectors_LastnameIgnoreCase(String lastname);

    // Find movies by original language
    List<MovieEntity> findByOriginalLanguageIgnoreCase(String language);

   List<MovieEntity> findByActorId(Long actorId);
}

