package de.moviereviews.infrastructure.persistence.repository;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<WatchlistEntity, Long> {
    List<WatchlistEntity> findByUser_Id(Long userId);
}

