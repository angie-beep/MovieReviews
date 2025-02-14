package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserMutationResolverTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserMutationResolver userMutationResolver;

    @Test
    void testCreateUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("John Doe");
        user.setEmail("john.doe@example.com");

        when(userService.createUser("John Doe", "john.doe@example.com"))
                .thenReturn(user);

        // Act
        User result = userMutationResolver.createUser("John Doe", "john.doe@example.com");

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getUsername());
        assertEquals("john.doe@example.com", result.getEmail());

        verify(userService, times(1)).createUser("John Doe", "john.doe@example.com");
    }

    @Test
    void testUpdateUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("Updated User");
        user.setEmail("updated@example.com");

        when(userService.updateUser(1L, "Updated User", "updated@example.com"))
                .thenReturn(user);

        // Act
        User result = userMutationResolver.updateUser(1L, "Updated User", "updated@example.com");

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated User", result.getUsername());
        assertEquals("updated@example.com", result.getEmail());

        verify(userService, times(1)).updateUser(1L, "Updated User", "updated@example.com");
    }

    @Test
    void testDeleteUser() {
        // Arrange
        when(userService.deleteUser(1L)).thenReturn(true);

        // Act
        Boolean result = userMutationResolver.deleteUser(1L);

        // Assert
        assertTrue(result);
        verify(userService, times(1)).deleteUser(1L);
    }
}
