package de.moviereview.infrastructure.persistence.repository;

//provides CRUD operations for the ActorEntity
//Provides basic in-memory data storage and retrieval operations for actors.

import de.moviereview.infrastructure.persistence.entity.ActorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorRepository {
    private final List<ActorEntity> actors = new ArrayList<>();

    public List<ActorEntity> findAll() {
        return actors;
    }

    public Optional<ActorEntity> findById(Long id) {
        return actors.stream().filter(actor -> actor.getId().equals(id)).findFirst();
    }

    public void save(ActorEntity actor) {
        actors.add(actor);
    }
}
