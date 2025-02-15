package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WatchlistMutationResolverTest {

    @Mock
    private WatchlistService watchlistService;

    @InjectMocks
    private WatchlistMutationResolver watchlistMutationResolver;

    @Test
    void testCreateWatchlist() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setId(1L);
        watchlist.setPublic(true);

        when(watchlistService.createWatchlist(5L, true))
                .thenReturn(watchlist);

        // Act
        WatchlistDTO result = watchlistMutationResolver.createWatchlist(5L, true);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertTrue(result.getIsPublic());

        verify(watchlistService, times(1)).createWatchlist(5L, true);
    }

    @Test
    void testAddMovieToWatchlist() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setId(1L);

        when(watchlistService.addMovieToWatchlist(1L, 10L))
                .thenReturn(watchlist);

        // Act
        WatchlistDTO result = watchlistMutationResolver.addMovieToWatchlist(1L, 10L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(watchlistService, times(1)).addMovieToWatchlist(1L, 10L);
    }

    @Test
    void testRemoveMovieFromWatchlist() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setId(1L);

        when(watchlistService.removeMovieFromWatchlist(1L, 10L))
                .thenReturn(watchlist);

        // Act
        WatchlistDTO result = watchlistMutationResolver.removeMovieFromWatchlist(1L, 10L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(watchlistService, times(1)).removeMovieFromWatchlist(1L, 10L);
    }

    @Test
    void testSetWatchlistPublicity() {
        // Arrange
        Watchlist watchlist = new Watchlist();
        watchlist.setId(1L);
        watchlist.setPublic(false);

        when(watchlistService.setWatchlistPublicity(1L, false))
                .thenReturn(watchlist);

        // Act
        WatchlistDTO result = watchlistMutationResolver.setWatchlistPublicity(1L, false);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertFalse(result.getIsPublic());

        verify(watchlistService, times(1)).setWatchlistPublicity(1L, false);
    }

    @Test
    void testDeleteWatchlist() {
        // Arrange
        when(watchlistService.deleteWatchlist(1L)).thenReturn(true);

        // Act
        Boolean result = watchlistMutationResolver.deleteWatchlist(1L);

        // Assert
        assertTrue(result);
        verify(watchlistService, times(1)).deleteWatchlist(1L);
    }
}
