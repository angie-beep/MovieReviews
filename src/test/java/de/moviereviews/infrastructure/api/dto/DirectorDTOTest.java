package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorDTOTest {

    @Test
    void testDirectorDTOSettersAndGetters() {
        // Arrange
        DirectorDTO directorDTO = new DirectorDTO();

        // Act
        directorDTO.setId(1L);
        directorDTO.setFirstName("Christopher");
        directorDTO.setLastName("Nolan");
        directorDTO.setBirthday("1970-07-30");
        directorDTO.setHeritage("British");

        // Assert
        assertEquals(1L, directorDTO.getId());
        assertEquals("Christopher", directorDTO.getFirstName());
        assertEquals("Nolan", directorDTO.getLastName());
        assertEquals("1970-07-30", directorDTO.getBirthday());
        assertEquals("British", directorDTO.getHeritage());
    }

    @Test
    void testDirectorDTODefaultConstructor() {
        // Arrange & Act
        DirectorDTO directorDTO = new DirectorDTO();

        // Assert
        assertNotNull(directorDTO);
        assertNull(directorDTO.getId());
        assertNull(directorDTO.getFirstName());
        assertNull(directorDTO.getLastName());
        assertNull(directorDTO.getBirthday());
        assertNull(directorDTO.getHeritage());
    }
}
