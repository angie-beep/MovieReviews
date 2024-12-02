package de.moviereview.infrastructure.persistence.dao;

/*

import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import org.junit.jupiter.api.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class ActorDaoImplTest {

    private static EntityManagerFactory emf;
    private ActorDaoImpl actorDao;

    @BeforeAll
    static void setUpClass() {
        // Initialisiere EntityManagerFactory mit einer In-Memory-H2-Datenbank
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    @BeforeEach
    void setUp() {
        actorDao = new ActorDaoImpl();
    }

    @AfterEach
    void tearDown() {
        actorDao.close();
    }

    @AfterAll
    static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    void testCreateAndRead() {
        // Arrange
        ActorEntity actor = new ActorEntity();
        actor.setFirstName("John");
        actor.setLastName("Doe");

        // Act
        actorDao.create(actor);
        ActorEntity retrievedActor = actorDao.read(actor.getId());

        // Assert
        assertNotNull(retrievedActor);
        assertEquals("John", retrievedActor.getFirstName());
        assertEquals("Doe", retrievedActor.getLastName());
    }

    @Test
    void testUpdateFirstname() {
        // Arrange
        ActorEntity actor = new ActorEntity();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        actorDao.create(actor);

        // Act
        actorDao.updateFirstname("Jane");
        ActorEntity updatedActor = actorDao.read(actor.getId());

        // Assert
        assertNotNull(updatedActor);
        assertEquals("Jane", updatedActor.getFirstName());
        assertEquals("Doe", updatedActor.getLastName());
    }

    @Test
    void testDelete() {
        // Arrange
        ActorEntity actor = new ActorEntity();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        actorDao.create(actor);

        // Act
        actorDao.delete(actor.getId());
        ActorEntity deletedActor = actorDao.read(actor.getId());

        // Assert
        assertNull(deletedActor);
    }
}
*/
