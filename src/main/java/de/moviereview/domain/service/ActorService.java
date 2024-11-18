package de.moviereview.domain.service;

//contains business logic and connects the controller to the persistence layer
//Contains business logic for managing actors in the application.

import de.moviereview.domain.model.Actor;
import de.moviereview.infrastructure.api.mapper.ActorMapper;
import de.moviereview.infrastructure.persistence.repository.ActorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll().stream()
                .map(ActorMapper::toModel)
                .collect(Collectors.toList());
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .map(ActorMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    public void saveActor(Actor actor) {
        actorRepository.save(ActorMapper.toEntity(actor));
    }
}
