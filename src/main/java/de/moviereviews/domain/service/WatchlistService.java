package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.api.mapper.WatchlistMapper;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;
import de.moviereviews.infrastructure.persistence.repository.MovieRepository;
import de.moviereviews.infrastructure.persistence.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WatchlistService {
@Autowired
    private final WatchlistRepository watchlistRepository;
@Autowired
    private final MovieRepository movieRepository;

    public WatchlistService(WatchlistRepository watchlistRepository, MovieRepository movieRepository) {
        this.watchlistRepository = watchlistRepository;
        this.movieRepository = movieRepository;
    }

    public Watchlist createWatchlist(Long userId, Boolean isPublic) {
        WatchlistEntity entity = new WatchlistEntity();
        entity.setPublic(isPublic);
        WatchlistEntity saved = watchlistRepository.save(entity);
        return WatchlistMapper.toDomain(saved);
    }

    public Watchlist addMovieToWatchlist(Long watchlistId, Long movieId) {
        WatchlistEntity watchlistEntity = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new NotFoundException("Watchlist not found"));
        MovieEntity movieEntity = movieRepository.findById(movieId)
                .orElseThrow(() -> new NotFoundException("Movie not found"));
        watchlistEntity.getMovies().add(movieEntity);
        WatchlistEntity saved = watchlistRepository.save(watchlistEntity);
        return WatchlistMapper.toDomain(saved);
    }

    public Watchlist removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        WatchlistEntity watchlistEntity = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new NotFoundException("Watchlist not found"));
        MovieEntity movieEntity = movieRepository.findById(movieId)
                .orElseThrow(() -> new NotFoundException("Movie not found"));
        watchlistEntity.getMovies().remove(movieEntity);
        WatchlistEntity saved = watchlistRepository.save(watchlistEntity);
        return WatchlistMapper.toDomain(saved);
    }

    public Watchlist setWatchlistPublicity(Long watchlistId, Boolean isPublic) {
        WatchlistEntity entity = watchlistRepository.findById(watchlistId).orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setPublic(isPublic);
        WatchlistEntity saved = watchlistRepository.save(entity);
        return WatchlistMapper.toDomain(saved);
    }

    public Boolean deleteWatchlist(Long id) {
        watchlistRepository.deleteById(id);
        return true;
    }

    public Watchlist getWatchlistById(Long id) {
        return watchlistRepository.findById(id)
                .map(WatchlistMapper::toDomain)
                .orElse(null);
    }

    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll().stream()
                .map(WatchlistMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<Watchlist> getWatchlistsByUserId(Long userId) {
        return watchlistRepository.findByUser_Id(userId).stream() .map(WatchlistMapper::toDomain) .collect(Collectors.toList());
    }

    public List<Watchlist> getPublicWatchlists() {
        return getAllWatchlists().stream()
                .filter(Watchlist::isPublic)
                .collect(Collectors.toList());
    }
}
