package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;
import de.moviereviews.infrastructure.persistence.repository.MovieRepository;
import de.moviereviews.infrastructure.persistence.repository.WatchlistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WatchlistServiceTest {

    @Mock
    private WatchlistRepository watchlistRepository;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private WatchlistService watchlistService;

    private WatchlistEntity watchlistEntity;
    private Watchlist watchlist;

    @BeforeEach
    void setUp() {
        watchlistEntity = new WatchlistEntity();
        watchlistEntity.setId(1L);
        watchlistEntity.setPublic(true);

        watchlist = WatchlistMapper.toDomain(watchlistEntity);
    }

    @Test
    void testCreateWatchlist() {
        when(watchlistRepository.save(any(WatchlistEntity.class))).thenReturn(watchlistEntity);

        Watchlist createdWatchlist = watchlistService.createWatchlist(1L, true);

        assertNotNull(createdWatchlist);
        assertTrue(createdWatchlist.isPublic());
        verify(watchlistRepository, times(1)).save(any(WatchlistEntity.class));
    }

    @Test
    void testAddMovieToWatchlist_Found() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(1L);

        when(watchlistRepository.findById(1L)).thenReturn(Optional.of(watchlistEntity));
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movieEntity));
        when(watchlistRepository.save(any(WatchlistEntity.class))).thenReturn(watchlistEntity);

        Watchlist updatedWatchlist = watchlistService.addMovieToWatchlist(1L, 1L);

        assertNotNull(updatedWatchlist);
        verify(watchlistRepository, times(1)).findById(1L);
        verify(movieRepository, times(1)).findById(1L);
        verify(watchlistRepository, times(1)).save(any(WatchlistEntity.class));
    }

    @Test
    void testAddMovieToWatchlist_WatchlistNotFound() {
        when(watchlistRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> watchlistService.addMovieToWatchlist(99L, 1L));
        verify(watchlistRepository, times(1)).findById(99L);
        verify(movieRepository, never()).findById(anyLong());
    }

    @Test
    void testRemoveMovieFromWatchlist_Found() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(1L);

        when(watchlistRepository.findById(1L)).thenReturn(Optional.of(watchlistEntity));
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movieEntity));
        when(watchlistRepository.save(any(WatchlistEntity.class))).thenReturn(watchlistEntity);

        Watchlist updatedWatchlist = watchlistService.removeMovieFromWatchlist(1L, 1L);

        assertNotNull(updatedWatchlist);
        verify(watchlistRepository, times(1)).findById(1L);
        verify(movieRepository, times(1)).findById(1L);
        verify(watchlistRepository, times(1)).save(any(WatchlistEntity.class));
    }

    @Test
    void testRemoveMovieFromWatchlist_WatchlistNotFound() {
        when(watchlistRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> watchlistService.removeMovieFromWatchlist(99L, 1L));
        verify(watchlistRepository, times(1)).findById(99L);
        verify(movieRepository, never()).findById(anyLong());
    }

    @Test
    void testSetWatchlistPublicity_Found() {
        when(watchlistRepository.findById(1L)).thenReturn(Optional.of(watchlistEntity));
        when(watchlistRepository.save(any(WatchlistEntity.class))).thenReturn(watchlistEntity);

        Watchlist updatedWatchlist = watchlistService.setWatchlistPublicity(1L, false);

        assertNotNull(updatedWatchlist);
        assertFalse(updatedWatchlist.isPublic());
        verify(watchlistRepository, times(1)).findById(1L);
        verify(watchlistRepository, times(1)).save(any(WatchlistEntity.class));
    }

    @Test
    void testSetWatchlistPublicity_NotFound() {
        when(watchlistRepository.findById(99L)).thenReturn(Optional.empty());

        Watchlist updatedWatchlist = watchlistService.setWatchlistPublicity(99L, false);

        assertNull(updatedWatchlist);
        verify(watchlistRepository, times(1)).findById(99L);
        verify(watchlistRepository, never()).save(any(WatchlistEntity.class));
    }

    @Test
    void testDeleteWatchlist() {
        doNothing().when(watchlistRepository).deleteById(1L);

        Boolean result = watchlistService.deleteWatchlist(1L);

        assertTrue(result);
        verify(watchlistRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetWatchlistById_Found() {
        when(watchlistRepository.findById(1L)).thenReturn(Optional.of(watchlistEntity));

        Watchlist foundWatchlist = watchlistService.getWatchlistById(1L);

        assertNotNull(foundWatchlist);
        assertEquals(1L, foundWatchlist.getId());
        verify(watchlistRepository, times(1)).findById(1L);
    }

    @Test
    void testGetWatchlistById_NotFound() {
        when(watchlistRepository.findById(99L)).thenReturn(Optional.empty());

        Watchlist foundWatchlist = watchlistService.getWatchlistById(99L);

        assertNull(foundWatchlist);
        verify(watchlistRepository, times(1)).findById(99L);
    }

    @Test
    void testGetAllWatchlists() {
        when(watchlistRepository.findAll()).thenReturn(Collections.singletonList(watchlistEntity));

        List<Watchlist> watchlists = watchlistService.getAllWatchlists();

        assertNotNull(watchlists);
        assertEquals(1, watchlists.size());
        verify(watchlistRepository, times(1)).findAll();
    }

    @Test
    void testGetPublicWatchlists() {
        when(watchlistRepository.findAll()).thenReturn(Collections.singletonList(watchlistEntity));

        List<Watchlist> publicWatchlists = watchlistService.getPublicWatchlists();

        assertNotNull(publicWatchlists);
        assertEquals(1, publicWatchlists.size());
        assertTrue(publicWatchlists.get(0).isPublic());
        verify(watchlistRepository, times(1)).findAll();
    }
}
