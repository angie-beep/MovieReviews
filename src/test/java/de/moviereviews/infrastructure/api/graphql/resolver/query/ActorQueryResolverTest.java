package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import de.moviereviews.infrastructure.api.dto.ActorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActorQueryResolverTest {

    @Mock
    private ActorService actorService;

    @InjectMocks
    private ActorQueryResolver actorQueryResolver;

    @Test
    void testGetActors() {
        // Arrange
        Actor actor = new Actor();
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");
        actor.setBirthday(LocalDate.parse("1999-12-12"));

        when(actorService.getAllActors()).thenReturn(Arrays.asList(actor));

        // Act
        Set<ActorDTO> result = actorQueryResolver.getActors();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(actorService, times(1)).getAllActors();
    }

    @Test
    void testGetActorById() {
        // Arrange
        Actor actor = new Actor();
        actor.setFirstName("Brad");
        actor.setLastName("Pitt");
        actor.setBirthday(LocalDate.parse("1999-12-12"));

        when(actorService.getActorById(1L)).thenReturn(actor);

        // Act
        ActorDTO result = actorQueryResolver.getActorById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Brad", result.getFirstName());
        verify(actorService, times(1)).getActorById(1L);
    }
}
