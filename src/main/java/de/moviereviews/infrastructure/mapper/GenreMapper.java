package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Genre;
import de.moviereviews.infrastructure.api.dto.GenreDTO;
import de.moviereviews.infrastructure.persistence.entity.GenreEntity;

public class GenreMapper {

    public static Genre toDomain(GenreEntity entity) {
        if (entity == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setId(entity.getId());
        genre.setGenre(entity.getGenre());
        return genre;
    }

    public static GenreDTO toDTO(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getGenre());
        return dto;
    }

    public static GenreEntity toEntity(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreEntity entity = new GenreEntity();
        entity.setId(genre.getId());
        entity.setGenre(genre.getGenre());
        return entity;
    }
}
