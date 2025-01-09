package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {

}

