package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.Director;
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
}
