package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.mapper.UserMapper;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WatchlistQueryResolver implements GraphQLQueryResolver {

    private final WatchlistService watchlistService;

    public WatchlistQueryResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    public WatchlistDTO getWatchlistById(Long id) {
        return WatchlistMapper.toDTO(watchlistService.getWatchlistById(id));
    }

    public List<WatchlistDTO> getAllWatchlists() {
        List<Watchlist> wlist = watchlistService.getAllWatchlists();
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<WatchlistDTO> getWatchlistsByUserId(Long userId) {
        List<Watchlist> wlist = watchlistService.getWatchlistsByUserId(userId);
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<WatchlistDTO> getPublicWatchlists() {
        List<Watchlist> wlist = watchlistService.getPublicWatchlists();
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }
}
