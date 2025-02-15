package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistMapperTest {

    private WatchlistEntity watchlistEntity;

    @BeforeEach
    void setUp() {
        // Erstelle eine WatchlistEntity mit gültigen Werten
        watchlistEntity = new WatchlistEntity();
        watchlistEntity.setId(1L);
        watchlistEntity.setPublic(true);

        // Setze einen User
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("testUser");
        userEntity.setEmail("test@example.com");
        watchlistEntity.setUser(userEntity);

        // Initialisiere die Movies-Collection mit einem Dummy-Movie
        HashSet<MovieEntity> movies = new HashSet<>();
        MovieEntity movie1 = new MovieEntity();
        movie1.setId(1L);
        // Hier können weitere Felder gesetzt werden, falls benötigt
        movies.add(movie1);
        watchlistEntity.setMovies(movies);
    }

    @Test
    void testToDomain() {
        // Act
        Watchlist watchlist = WatchlistMapper.toDomain(watchlistEntity);

        // Assert
        assertNotNull(watchlist, "Domain-Objekt sollte nicht null sein");
        assertEquals(1L, watchlist.getId());
        assertTrue(watchlist.isPublic());
        assertNotNull(watchlist.getUser(), "User darf nicht null sein");
        assertNotNull(watchlist.getMovies(), "Movies-Collection darf nicht null sein");
        assertEquals(1, watchlist.getMovies().size(), "Es sollte genau ein Movie vorhanden sein");
    }

    @Test
    void testToDTO() {
        // Arrange: Domain-Objekt erzeugen
        Watchlist watchlist = WatchlistMapper.toDomain(watchlistEntity);

        // Act
        WatchlistDTO dto = WatchlistMapper.toDTO(watchlist);

        // Assert
        assertNotNull(dto, "DTO sollte nicht null sein");
        assertEquals(1L, dto.getId());
        assertTrue(dto.getIsPublic());
        assertNotNull(dto.getUser(), "User im DTO darf nicht null sein");
        assertNotNull(dto.getMovies(), "Movies im DTO dürfen nicht null sein");
        assertEquals(1, dto.getMovies().size(), "Es sollte genau ein Movie im DTO vorhanden sein");
    }

    @Test
    void testToEntity() {
        // Arrange: Domain-Objekt erzeugen
        Watchlist watchlist = WatchlistMapper.toDomain(watchlistEntity);

        // Act
        WatchlistEntity entity = WatchlistMapper.toEntity(watchlist);

        // Assert
        assertNotNull(entity, "Entity sollte nicht null sein");
        assertEquals(1L, entity.getId());
        assertEquals(watchlist.isPublic(), entity.isPublic());
        assertNotNull(entity.getUser(), "User in der Entity darf nicht null sein");
        assertNotNull(entity.getMovies(), "Movies in der Entity dürfen nicht null sein");
        // Optionale Prüfung der Anzahl Filme
        assertEquals(watchlist.getMovies().size(), entity.getMovies().size());
    }
}
