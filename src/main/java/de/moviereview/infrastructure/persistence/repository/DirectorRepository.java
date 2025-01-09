package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.infrastructure.persistence.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

}
