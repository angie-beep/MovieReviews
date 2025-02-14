package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.ActorDTO;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActorMapper {

    public static Actor toDomain(ActorEntity entity) {
        Actor actor = new Actor();
        actor.setId(entity.getId());
        actor.setFirstName(entity.getFirstName());
        actor.setLastName(entity.getLastName());
        actor.setBirthday(entity.getBirthday());
        actor.setHeritage(entity.getHeritage());
        return actor;
    }

    public static ActorDTO toDTO(Actor actor) {
        ActorDTO dto = new ActorDTO();
        dto.setId(actor.getId());
        dto.setFirstName(actor.getFirstName());
        dto.setLastName(actor.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        dto.setBirthday(actor.getBirthday().toString());
        dto.setHeritage(actor.getHeritage());
        return dto;
    }

    public static ActorEntity toEntity(Actor actor) {
        ActorEntity entity = new ActorEntity();
        entity.setId(actor.getId());
        entity.setFirstName(actor.getFirstName());
        entity.setLastName(actor.getLastName());
        entity.setBirthday(actor.getBirthday());
        entity.setHeritage(actor.getHeritage());
        return entity;
    }
}
