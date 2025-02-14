package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MovieRankingService {

    public List<Movie> getTop3MoviesForActor(Actor actor) {
        if (actor.getMovies() == null || actor.getMovies().isEmpty()) {
            return List.of();
        }
        return actor.getMovies().stream()
                .sorted((m1, m2) -> Double.compare(m2.getOverallRating(), m1.getOverallRating()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Movie> getTop3MoviesForDirector(Director director) {
        if (director.getMovies() == null || director.getMovies().isEmpty()) {
            return List.of();
        }
        return director.getMovies().stream()
                .sorted((m1, m2) -> Double.compare(m2.getOverallRating(), m1.getOverallRating()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
