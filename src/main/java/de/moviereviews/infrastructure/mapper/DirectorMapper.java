package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Director;
import de.moviereviews.infrastructure.api.dto.DirectorDTO;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;

public class DirectorMapper {

    public static Director toDomain(DirectorEntity entity) {
        Director director = new Director();
        director.setId(entity.getId());
        director.setFirstName(entity.getFirstName());
        director.setLastName(entity.getLastName());
        director.setBirthday(entity.getBirthday());
        director.setHeritage(entity.getHeritage());
        return director;
    }

    public static DirectorDTO toDTO(Director director) {
        DirectorDTO dto = new DirectorDTO();
        dto.setId(director.getId());
        dto.setFirstName(director.getFirstName());
        dto.setLastName(director.getLastName());
        dto.setBirthday(director.getBirthday() != null ? director.getBirthday().toString() : null);
        dto.setHeritage(director.getHeritage());
        return dto;
    }

    public static DirectorEntity toEntity(Director director) {
        DirectorEntity entity = new DirectorEntity();
        entity.setId(director.getId());
        entity.setFirstName(director.getFirstName());
        entity.setLastName(director.getLastName());
        entity.setBirthday(director.getBirthday());
        entity.setHeritage(director.getHeritage());
        return entity;
    }

}
