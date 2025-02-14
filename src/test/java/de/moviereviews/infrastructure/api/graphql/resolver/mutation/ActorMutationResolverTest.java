package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import de.moviereviews.infrastructure.api.dto.ActorDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActorMutationResolverTest {

    @Mock
    private ActorService actorService;

    @InjectMocks
    private ActorMutationResolver actorMutationResolver;

    @Test
    void testAddActor() {
        // Arrange
        Actor actor = new Actor();
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");
        actor.setBirthday(LocalDate.parse("1974-11-11"));
        actor.setHeritage("American");

        ActorDTO expectedActorDTO = ActorMapper.toDTO(actor);

        when(actorService.addActor("Leonardo", "DiCaprio", "1974-11-11", "American"))
                .thenReturn(actor);

        // Act
        ActorDTO result = actorMutationResolver.addActor("Leonardo", "DiCaprio", "1974-11-11", "American");

        // Assert
        assertNotNull(result);
        assertEquals(expectedActorDTO.getFirstName(), result.getFirstName());
        assertEquals(expectedActorDTO.getLastName(), result.getLastName());
        assertEquals(expectedActorDTO.getBirthday(), result.getBirthday());
        assertEquals(expectedActorDTO.getHeritage(), result.getHeritage());

        verify(actorService, times(1)).addActor("Leonardo", "DiCaprio", "1974-11-11", "American");
    }
}
