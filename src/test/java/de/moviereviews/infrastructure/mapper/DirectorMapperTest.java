package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Director;
import de.moviereviews.infrastructure.mapper.DirectorMapper;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DirectorMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        DirectorEntity entity = new DirectorEntity();
        entity.setId(1L);
        entity.setFirstName("Christopher");
        entity.setLastName("Nolan");
        entity.setBirthday(LocalDate.of(1970, 7, 30));
        entity.setHeritage("British");

        // Act
        Director director = DirectorMapper.toDomain(entity);

        // Assert
        assertNotNull(director);
        assertEquals(1L, director.getId());
        assertEquals("Christopher", director.getFirstName());
        assertEquals("Nolan", director.getLastName());
        assertEquals(LocalDate.of(1970, 7, 30), director.getBirthday());
        assertEquals("British", director.getHeritage());
    }
}
