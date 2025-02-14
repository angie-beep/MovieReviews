package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.infrastructure.api.dto.ActorDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ActorMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        ActorEntity entity = new ActorEntity();
        entity.setId(1L);
        entity.setFirstName("Leonardo");
        entity.setLastName("DiCaprio");
        entity.setBirthday(LocalDate.of(1974, 11, 11));
        entity.setHeritage("American");

        // Act
        Actor actor = ActorMapper.toDomain(entity);

        // Assert
        assertNotNull(actor);
        assertEquals(1L, actor.getId());
        assertEquals("Leonardo", actor.getFirstName());
        assertEquals("DiCaprio", actor.getLastName());
        assertEquals(LocalDate.of(1974, 11, 11), actor.getBirthday());
        assertEquals("American", actor.getHeritage());
    }

    @Test
    void testToDTO() {
        // Arrange
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");
        actor.setBirthday(LocalDate.of(1974, 11, 11));
        actor.setHeritage("American");

        // Act
        ActorDTO dto = ActorMapper.toDTO(actor);

        // Assert
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Leonardo", dto.getFirstName());
        assertEquals("DiCaprio", dto.getLastName());
        assertEquals("1974-11-11", dto.getBirthday()); // Prüft, ob das Datum korrekt formatiert wurde
        assertEquals("American", dto.getHeritage());
    }

    @Test
    void testToEntity() {
        // Arrange
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");
        actor.setBirthday(LocalDate.of(1974, 11, 11));
        actor.setHeritage("American");

        // Act
        ActorEntity entity = ActorMapper.toEntity(actor);

        // Assert
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("Leonardo", entity.getFirstName());
        assertEquals("DiCaprio", entity.getLastName());
        assertEquals(LocalDate.of(1974, 11, 11), entity.getBirthday());
        assertEquals("American", entity.getHeritage());
    }
}
