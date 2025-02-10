package de.moviereview.domain.service;

//contains business logic and connects the controller to the persistence layer
//Contains business logic for managing actors in the application.

import de.moviereview.domain.model.Actor;
import de.moviereview.infrastructure.api.mapper.ActorMapper;
import de.moviereview.infrastructure.persistence.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorService {
    @Autowired
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

    public Actor addActor(String firstname, String lastname, String birthday, String heritage) {

        return null;
    }
}
