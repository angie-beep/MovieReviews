package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.domain.model.Actor;
import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ActorRepository{
    void create(Actor actor);
}

