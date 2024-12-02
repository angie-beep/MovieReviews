package de.moviereview.resolver.mutation;
import de.moviereview.domain.model.User;
import de.moviereview.domain.model.Movie;
import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;
import de.moviereview.infrastructure.persistence.repository.UserRepository;
import de.moviereview.infrastructure.persistence.repository.WatchlistRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class WatchlistMutation implements GraphQLMutationResolver {

    private final WatchlistRepository watchlistRepository = new WatchlistRepository();
    private final UserRepository userRepository = new UserRepository();
    private final MovieRepository movieRepository = new MovieRepository();

    // Create a new Watchlist
    public Watchlist createWatchlist(String name, Long userId, Boolean isPrivate) {
        // Validate the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        Watchlist watchlist = new Watchlist();
        watchlist.setUser(user);
        watchlist.setPublic(isPrivate != null ? isPrivate : false);

        return watchlistRepository.save(watchlist);
    }

    // Add a Movie to an existing Watchlist
    public Watchlist addMovieToWatchlist(Long watchlistId, Long movieId) {
        // Find the watchlist
        Watchlist watchlist = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found with ID: " + watchlistId));

        // Find the movie
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        // Add the movie to the watchlist
        watchlist.getMovies().add(movie);
        return watchlistRepository.save(watchlist);
    }

    // Remove a Movie from a Watchlist
    public Watchlist removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        // Find the watchlist
        Watchlist watchlist = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found with ID: " + watchlistId));

        // Find the movie
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        // Remove the movie from the watchlist
        watchlist.getMovies().remove(movie);
        return watchlistRepository.save(watchlist);
    }

    // Delete a Watchlist
    public Boolean deleteWatchlist(Long id) {
        if (!watchlistRepository.existsById(id)) {
            throw new IllegalArgumentException("Watchlist not found with ID: " + id);
        }
        watchlistRepository.deleteById(id);
        return true;
    }
}