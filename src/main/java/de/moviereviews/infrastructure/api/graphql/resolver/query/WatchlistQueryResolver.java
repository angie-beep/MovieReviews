package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.mapper.UserMapper;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;

@Controller
public class WatchlistQueryResolver {

    private final WatchlistService watchlistService;

    public WatchlistQueryResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }
    @QueryMapping
    public WatchlistDTO getWatchlistById(Long id) {
        return WatchlistMapper.toDTO(watchlistService.getWatchlistById(id));
    }
    @QueryMapping
    public List<WatchlistDTO> getAllWatchlists() {
        List<Watchlist> wlist = watchlistService.getAllWatchlists();
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }
    @QueryMapping
    public List<WatchlistDTO> getWatchlistsByUserId(Long userId) {
        List<Watchlist> wlist = watchlistService.getWatchlistsByUserId(userId);
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }
    @QueryMapping
    public List<WatchlistDTO> getPublicWatchlists() {
        List<Watchlist> wlist = watchlistService.getPublicWatchlists();
        return  wlist.stream()
                .map(WatchlistMapper::toDTO)
                .collect(Collectors.toList());
    }
}
