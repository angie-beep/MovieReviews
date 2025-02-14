package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
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
class WatchlistQueryResolverTest {

    @Mock
    private WatchlistService watchlistService;

    @InjectMocks
    private WatchlistQueryResolver watchlistQueryResolver;

    @Test
    void testGetWatchlistById() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setId(1L);
        watchlist.setPublic(true);

        when(watchlistService.getWatchlistById(1L)).thenReturn(watchlist);

        // Act
        Watchlist result = watchlistQueryResolver.getWatchlistById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertTrue(result.isPublic());

        verify(watchlistService, times(1)).getWatchlistById(1L);
    }

    @Test
    void testGetAllWatchlists() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setPublic(true);

        when(watchlistService.getAllWatchlists()).thenReturn(Arrays.asList(watchlist));

        // Act
        List<Watchlist> result = watchlistQueryResolver.getAllWatchlists();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).isPublic());

        verify(watchlistService, times(1)).getAllWatchlists();
    }

    @Test
    void testGetPublicWatchlists() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setPublic(true);

        when(watchlistService.getPublicWatchlists()).thenReturn(Arrays.asList(watchlist));

        // Act
        List<Watchlist> result = watchlistQueryResolver.getPublicWatchlists();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).isPublic());

        verify(watchlistService, times(1)).getPublicWatchlists();
    }
}
