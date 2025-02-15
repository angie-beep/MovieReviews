package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import de.moviereviews.infrastructure.api.dto.DirectorDTO;
import de.moviereviews.infrastructure.mapper.DirectorMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DirectorMutationResolverTest {

    @Mock
    private DirectorService directorService;

    @InjectMocks
    private DirectorMutationResolver directorMutationResolver;

    @Test
    void testAddDirector() {
        // Arrange
        Director director = new Director();
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthday(LocalDate.parse("1970-07-30"));
        director.setHeritage("British");

        when(directorService.addDirector("Christopher", "Nolan", "1970-07-30", "British"))
                .thenReturn(director);

        // Act
        DirectorDTO result = directorMutationResolver.addDirector("Christopher", "Nolan", "1970-07-30", "British");

        // Assert
        assertNotNull(result);
        assertEquals("Christopher", result.getFirstName());
        assertEquals("Nolan", result.getLastName());
        assertEquals("1970-07-30", result.getBirthday());
        assertEquals("British", result.getHeritage());

        verify(directorService, times(1)).addDirector("Christopher", "Nolan", "1970-07-30", "British");
    }
}
