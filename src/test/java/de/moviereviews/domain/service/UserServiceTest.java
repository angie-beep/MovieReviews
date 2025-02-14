package de.moviereviews.domain.service;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.mapper.UserMapper;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;
import de.moviereviews.infrastructure.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserEntity userEntity;
    private User user;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("testuser");
        userEntity.setEmail("testuser@example.com");

        user = UserMapper.toDomain(userEntity);
    }

    @Test
    void testCreateUser() {
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        User createdUser = userService.createUser("testuser", "testuser@example.com");

        assertNotNull(createdUser);
        assertEquals("testuser", createdUser.getUsername());
        assertEquals("testuser@example.com", createdUser.getEmail());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void testUpdateUser_Found() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        User updatedUser = userService.updateUser(1L, "updatedUser", "updated@example.com");

        assertNotNull(updatedUser);
        assertEquals("updatedUser", updatedUser.getUsername());
        assertEquals("updated@example.com", updatedUser.getEmail());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void testUpdateUser_NotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User updatedUser = userService.updateUser(99L, "updatedUser", "updated@example.com");

        assertNull(updatedUser);
        verify(userRepository, times(1)).findById(99L);
        verify(userRepository, never()).save(any(UserEntity.class));
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        Boolean result = userService.deleteUser(1L);

        assertTrue(result);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetUserById_Found() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        User foundUser = userService.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User foundUser = userService.getUserById(99L);

        assertNull(foundUser);
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(userEntity));

        List<User> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("testuser", users.get(0).getUsername());
        verify(userRepository, times(1)).findAll();
    }
}

