package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.mapper.UserMapper;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setUsername("John Doe");
        entity.setEmail("john.doe@example.com");

        // Act
        User user = UserMapper.toDomain(entity);

        // Assert
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getUsername());
        assertEquals("john.doe@example.com", user.getEmail());
    }
}
