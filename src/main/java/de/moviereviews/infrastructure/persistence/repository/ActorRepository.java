package de.moviereviews.infrastructure.persistence.repository;

import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
}
