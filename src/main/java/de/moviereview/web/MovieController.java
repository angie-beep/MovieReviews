package de.moviereview.web;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.service.MovieService;

import java.util.List;

public class MovieController {

    private MovieService movieService;

    public MovieController() {
        // Manuelle Erstellung der Service-Instanz
        this.movieService = new MovieService();
    }

    // Methode zum Abrufen aller Filme
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Methode zum Erstellen eines neuen Films
    public Movie createMovie(Movie movie) {
        return movieService.saveMovie(movie);
    }

    // Methode zum Abrufen eines Films nach ID
    public Movie getMovieById(Long id) {
        return movieService.findMovieById(id);
    }

    // Methode zum Löschen eines Films nach ID
    public void deleteMovie(Long id) {
        movieService.deleteMovie(id);
    }
}