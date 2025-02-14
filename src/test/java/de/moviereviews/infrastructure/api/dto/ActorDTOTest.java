package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorDTOTest {

    @Test
    void testActorDTOSettersAndGetters() {
        // Arrange
        ActorDTO actorDTO = new ActorDTO();

        // Act
        actorDTO.setId(1L);
        actorDTO.setFirstName("Leonardo");
        actorDTO.setLastName("DiCaprio");
        actorDTO.setBirthday("1974-11-11");
        actorDTO.setHeritage("American");

        // Assert
        assertEquals(1L, actorDTO.getId());
        assertEquals("Leonardo", actorDTO.getFirstName());
        assertEquals("DiCaprio", actorDTO.getLastName());
        assertEquals("1974-11-11", actorDTO.getBirthday());
        assertEquals("American", actorDTO.getHeritage());
    }

    @Test
    void testActorDTODefaultConstructor() {
        // Arrange & Act
        ActorDTO actorDTO = new ActorDTO();

        // Assert
        assertNotNull(actorDTO);
        assertNull(actorDTO.getId());
        assertNull(actorDTO.getFirstName());
        assertNull(actorDTO.getLastName());
        assertNull(actorDTO.getBirthday());
        assertNull(actorDTO.getHeritage());
    }
}
