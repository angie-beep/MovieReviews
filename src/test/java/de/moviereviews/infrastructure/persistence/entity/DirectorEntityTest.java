package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DirectorEntityTest {

    @Test
    void testDirectorEntity() {
        // Arrange & Act
        DirectorEntity director = new DirectorEntity();
        director.setId(1L);
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthday(LocalDate.of(1970, 7, 30));
        director.setHeritage("British");

        // Assert
        assertEquals(1L, director.getId());
        assertEquals("Christopher", director.getFirstName());
        assertEquals("Nolan", director.getLastName());
        assertEquals(LocalDate.of(1970, 7, 30), director.getBirthday());
        assertEquals("British", director.getHeritage());
    }
}
