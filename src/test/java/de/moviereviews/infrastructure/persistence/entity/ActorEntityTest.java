package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ActorEntityTest {

    @Test
    void testActorEntity() {
        // Arrange & Act
        ActorEntity actor = new ActorEntity();
        actor.setId(1L);
        actor.setFirstName("Leonardo");
        actor.setLastName("DiCaprio");
        actor.setBirthday(LocalDate.of(1974, 11, 11));
        actor.setHeritage("American");

        // Assert
        assertEquals(1L, actor.getId());
        assertEquals("Leonardo", actor.getFirstName());
        assertEquals("DiCaprio", actor.getLastName());
        assertEquals(LocalDate.of(1974, 11, 11), actor.getBirthday());
        assertEquals("American", actor.getHeritage());
    }
}
