package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

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

        when(actorService.getAllActors()).thenReturn(Arrays.asList(actor));

        // Act
        List<Actor> result = actorQueryResolver.getActors();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Leonardo", result.get(0).getFirstName());
        verify(actorService, times(1)).getAllActors();
    }

    @Test
    void testGetActorById() {
        // Arrange
        Actor actor = new Actor();
        actor.setFirstName("Brad");
        actor.setLastName("Pitt");

        when(actorService.getActorById(1L)).thenReturn(actor);

        // Act
        Actor result = actorQueryResolver.getActorById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Brad", result.getFirstName());
        verify(actorService, times(1)).getActorById(1L);
    }
}
