package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void testUserDTOSettersAndGetters() {
        // Arrange
        UserDTO userDTO = new UserDTO();

        // Act
        userDTO.setId(1L);
        userDTO.setName("John Doe");
        userDTO.setEmail("john.doe@example.com");

        // Assert
        assertEquals(1L, userDTO.getId());
        assertEquals("John Doe", userDTO.getName());
        assertEquals("john.doe@example.com", userDTO.getEmail());
    }

    @Test
    void testUserDTODefaultConstructor() {
        // Arrange & Act
        UserDTO userDTO = new UserDTO();

        // Assert
        assertNotNull(userDTO);
        assertNull(userDTO.getId());
        assertNull(userDTO.getName());
        assertNull(userDTO.getEmail());
    }
}
