package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Actor;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import de.moviereviews.infrastructure.persistence.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
                .map(ActorMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id) .map(ActorMapper::toDomain) .orElseThrow(() -> new NotFoundException("Actor with id " + id + " not found"));
    }

    public Actor addActor(String firstName, String lastName, String birthday, String heritage) {
        ActorEntity entity = new ActorEntity();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        if (birthday != null && !birthday.isEmpty()) {
            entity.setBirthday(LocalDate.parse(birthday));
        }
        entity.setHeritage(heritage);
        ActorEntity saved = actorRepository.save(entity);
        return ActorMapper.toDomain(saved);
    }
}
