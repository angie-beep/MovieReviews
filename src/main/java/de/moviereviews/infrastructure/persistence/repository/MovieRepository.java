package de.moviereviews.infrastructure.persistence.repository;

import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    Page<MovieEntity> findByGenresContainingIgnoreCaseAndOriginalLanguageContainingIgnoreCase(
            String genres,
            String originalLanguage,
            Pageable pageable);

    List<MovieEntity> findByActors_Id(Long actorId);
    List<MovieEntity> findByGenresGenreContainingIgnoreCaseOrderByOverallRatingDesc(String genre);

}
