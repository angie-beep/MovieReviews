package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import de.moviereviews.infrastructure.api.dto.DirectorDTO;
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
class DirectorQueryResolverTest {

    @Mock
    private DirectorService directorService;

    @InjectMocks
    private DirectorQueryResolver directorQueryResolver;

    @Test
    void testGetDirectors() {
        // Arrange
        Director director = new Director();
        director.setFirstName("Christopher");
        director.setLastName("Nolan");

        when(directorService.getAllDirectors()).thenReturn(Arrays.asList(director));

        // Act
        Set<DirectorDTO> result = directorQueryResolver.getDirectors();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(directorService, times(1)).getAllDirectors();
    }

    @Test
    void testGetDirectorById() {
        // Arrange
        Director director = new Director();
        director.setFirstName("Quentin");
        director.setLastName("Tarantino");

        when(directorService.getDirectorById(1L)).thenReturn(director);

        // Act
        DirectorDTO result = directorQueryResolver.getDirectorById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Quentin", result.getFirstName());
        verify(directorService, times(1)).getDirectorById(1L);
    }
}
