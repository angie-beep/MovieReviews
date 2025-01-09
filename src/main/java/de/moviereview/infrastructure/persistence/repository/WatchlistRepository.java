package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository<WatchlistEntity, Long> {

}
