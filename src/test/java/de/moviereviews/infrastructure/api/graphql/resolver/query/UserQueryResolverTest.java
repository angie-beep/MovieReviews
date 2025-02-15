package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import de.moviereviews.infrastructure.api.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserQueryResolverTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserQueryResolver userQueryResolver;

    @Test
    void testGetUserById() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("John Doe");
        user.setEmail("john.doe@example.com");

        when(userService.getUserById(1L)).thenReturn(user);

        // Act
        UserDTO result = userQueryResolver.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getUsername());
        assertEquals("john.doe@example.com", result.getEmail());

        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        User user = new User();
        user.setUsername("Jane Doe");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user));

        // Act
        List<UserDTO> result = userQueryResolver.getAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());


        verify(userService, times(1)).getAllUsers();
    }
}
