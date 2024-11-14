package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.repository.MovieRepository;

import java.util.List;
//Die Klasse ist fürrr Geschäftslogik und die ruf das repository auf
//um DB-transaktionen durchzuführen
public class MovieService {

    private MovieRepository movieRepository = new MovieRepository();

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public void closeRepository() {
        movieRepository.close();
    }
}