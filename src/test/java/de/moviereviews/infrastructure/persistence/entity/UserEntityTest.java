package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testUserEntity() {
        // Arrange & Act
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("John Doe");
        user.setEmail("john.doe@example.com");
        user.setNotificationsEnabled(true);

        // Assert
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getUsername());
        assertEquals("john.doe@example.com", user.getEmail());
        assertTrue(user.isNotificationsEnabled());
    }
}
