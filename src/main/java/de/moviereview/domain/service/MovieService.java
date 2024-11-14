package de.moviereview.domain.service;

//Die Klasse ist fürrr Geschäftslogik und die ruf das repository auf
//um DB-transaktionen durchzuführen
public class MovieService {

   /* private MovieRepository movieRepository = new MovieRepository();
    private TMDbService tmdbService = new TMDbService();

    public Movie importMovieFromTMDb(String tmdbId) {
        // Holen der Filmdetails von der TMDb API
        Movie movieFromTMDb = tmdbService.fetchMovieDetails(tmdbId);
        if (movieFromTMDb != null) {
            // Speichern des Films in der lokalen Datenbank
            return movieRepository.save(movieFromTMDb);
        }
        System.out.println("Fehler: Film konnte nicht importiert werden.");
        return null;
    }

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
    }*/
}