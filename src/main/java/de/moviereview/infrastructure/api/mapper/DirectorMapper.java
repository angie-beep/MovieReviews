package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Director;
import de.moviereview.infrastructure.api.dto.DirectorDTO;
import de.moviereview.infrastructure.persistence.entity.DirectorEntity;

import java.util.stream.Collectors;

public class DirectorMapper {

    public static Director toModel(DirectorEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("DirectorEntity cannot be null");
        }
        return new Director(
                entity.getId(),
                entity.getLastName(),
                entity.getFirstName(),
                entity.getBirthday(),
                entity.getHeritage(),
                entity.getMovies() != null ? entity.getMovies().stream().map(MovieMapper::toModel).collect(Collectors.toSet()) : null
        );
    }

    public static DirectorEntity toEntity(Director model) {
        if (model == null) {
            throw new IllegalArgumentException("Director model cannot be null");
        }
        DirectorEntity entity = new DirectorEntity();
        entity.setId(model.getId());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setBirthday(model.getBirthday());
        entity.setHeritage(model.getHeritage());
        entity.setMovies(model.getMovies() != null ? model.getMovies().stream().map(MovieMapper::toEntity).collect(Collectors.toSet()) : null);
        return entity;
    }

    public static DirectorDTO toDto(Director model) {
        if (model == null) {
            throw new IllegalArgumentException("Director model cannot be null");
        }
        DirectorDTO dto = new DirectorDTO();
        dto.setId(model.getId());
        dto.setLastname(model.getLastName());
        dto.setFirstname(model.getFirstName());
        dto.setBirthday(model.getBirthday());
        dto.setHeritage(model.getHeritage());
        dto.setMovieIds(model.getMovies() != null ? model.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toSet()) : null);
        return dto;
    }

    public static Director toModel(DirectorDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("DirectorDTO cannot be null");
        }
        return new Director(
                dto.getId(),
                dto.getLastname(),
                dto.getFirstname(),
                dto.getBirthday(),
                dto.getHeritage(),
                null // Mapping movie IDs to Movie objects should be handled separately
        );
    }
}
