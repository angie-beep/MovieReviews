package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(1L);
        entity.setPublic(true);

        // Act
        Watchlist watchlist = WatchlistMapper.toDomain(entity);

        // Assert
        assertNotNull(watchlist);
        assertEquals(1L, watchlist.getId());
        assertTrue(watchlist.isPublic());
    }
}
