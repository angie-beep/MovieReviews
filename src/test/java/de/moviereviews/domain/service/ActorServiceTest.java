package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Actor;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import de.moviereviews.infrastructure.persistence.repository.ActorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActorServiceTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorService actorService;

    private ActorEntity actorEntity1;
    private ActorEntity actorEntity2;

    @BeforeEach
    void setUp() {
        actorEntity1 = new ActorEntity();
        actorEntity1.setId(1L);
        actorEntity1.setFirstName("Leonardo");
        actorEntity1.setLastName("DiCaprio");
        actorEntity1.setBirthday(LocalDate.of(1974, 11, 11));
        actorEntity1.setHeritage("American");

        actorEntity2 = new ActorEntity();
        actorEntity2.setId(2L);
        actorEntity2.setFirstName("Brad");
        actorEntity2.setLastName("Pitt");
        actorEntity2.setBirthday(LocalDate.of(1963, 12, 18));
        actorEntity2.setHeritage("American");
    }

    @Test
    void testGetAllActors() {
        // Arrange
        when(actorRepository.findAll()).thenReturn(Arrays.asList(actorEntity1, actorEntity2));

        // Act
        List<Actor> actors = actorService.getAllActors();

        // Assert
        assertNotNull(actors);
        assertEquals(2, actors.size());
        assertEquals("Leonardo", actors.get(0).getFirstName());
        assertEquals("Brad", actors.get(1).getFirstName());
        verify(actorRepository, times(1)).findAll();
    }

    @Test
    void testGetActorById_Found() {
        // Arrange
        when(actorRepository.findById(1L)).thenReturn(Optional.of(actorEntity1));

        // Act
        Actor actor = actorService.getActorById(1L);

        // Assert
        assertNotNull(actor);
        assertEquals("Leonardo", actor.getFirstName());
        verify(actorRepository, times(1)).findById(1L);
    }

    @Test
    void testGetActorById_NotFound() {
        // Arrange
        when(actorRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> actorService.getActorById(99L));
        assertEquals("Actor with id 99 not found", thrown.getMessage());
        verify(actorRepository, times(1)).findById(99L);
    }

    @Test
    void testAddActor_WithBirthday() {
        // Arrange
        ActorEntity savedEntity = new ActorEntity();
        savedEntity.setId(3L);
        savedEntity.setFirstName("Tom");
        savedEntity.setLastName("Hanks");
        savedEntity.setBirthday(LocalDate.of(1956, 7, 9));
        savedEntity.setHeritage("American");

        when(actorRepository.save(any(ActorEntity.class))).thenReturn(savedEntity);

        // Act
        Actor actor = actorService.addActor("Tom", "Hanks", "1956-07-09", "American");

        // Assert
        assertNotNull(actor);
        assertEquals("Tom", actor.getFirstName());
        assertEquals(LocalDate.of(1956, 7, 9), actor.getBirthday());
        verify(actorRepository, times(1)).save(any(ActorEntity.class));
    }

    @Test
    void testAddActor_WithoutBirthday() {
        // Arrange
        ActorEntity savedEntity = new ActorEntity();
        savedEntity.setId(4L);
        savedEntity.setFirstName("Morgan");
        savedEntity.setLastName("Freeman");
        savedEntity.setHeritage("American");

        when(actorRepository.save(any(ActorEntity.class))).thenReturn(savedEntity);

        // Act
        Actor actor = actorService.addActor("Morgan", "Freeman", "", "American");

        // Assert
        assertNotNull(actor);
        assertEquals("Morgan", actor.getFirstName());
        assertNull(actor.getBirthday());
        verify(actorRepository, times(1)).save(any(ActorEntity.class));
    }
}
