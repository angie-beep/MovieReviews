package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.api.dto.MoviePageDTO;
import de.moviereviews.infrastructure.api.mapper.MovieMapper;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import de.moviereviews.infrastructure.persistence.entity.GenreEntity;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.repository.GenreRepository;
import de.moviereviews.infrastructure.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }


    public Movie addMovie(String title, Set<GenreEntity> genres, LocalDate publishingDate, Set<DirectorEntity> directors, Set<ActorEntity> actors, String originalLanguage, Integer length, Float rating) {
        MovieEntity entity = new MovieEntity();
        entity.setTitle(title);
        if (title != null && !title.isEmpty()) {
            entity.setPublishingDate(LocalDate.parse(title));
        }
        entity.setOriginalLanguage(originalLanguage);
        entity.setLength(length);
        entity.setOverallRating(rating);
        entity.setDirectors(directors);
        entity.setActors(actors);
        entity.setGenres(genres);

        MovieEntity saved = movieRepository.save(entity);
        return MovieMapper.toDomain(saved);
    }

    public Movie updateMovie(Long id, String title, Set<GenreEntity> genres, LocalDate publishingDate, Set<DirectorEntity> directors, Set<ActorEntity> actors, String originalLanguage, Integer length, Float rating) {
        Optional<MovieEntity> entityOpt = movieRepository.findById(id);
        if (!entityOpt.isPresent()) {
            return null;
        }
        MovieEntity entity = entityOpt.get();
        if (title != null) {
            entity.setTitle(title);
        }
        if (publishingDate != null) {
            entity.setPublishingDate(publishingDate);
        }
        if (originalLanguage != null) {
            entity.setOriginalLanguage(originalLanguage);
        }
        if (length != null) {
            entity.setLength(length);
        }
        if (rating != null) {
            entity.setOverallRating(rating);
        }

        entity.setDirectors(directors);
        entity.setActors(actors);
        entity.setGenres(genres);
        // Genre und Regisseure werden hier als Platzhalter ignoriert
        MovieEntity saved = movieRepository.save(entity);
        return MovieMapper.toDomain(saved);
    }

    public Boolean deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return true;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getAllMovieDTOs() {
        return getAllMovies().stream()
                .map(MovieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MoviePageDTO getMoviesByFilters(String genre, String director, String originalLanguage, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        String genreFilter = (genre != null) ? genre : "";
        String languageFilter = (originalLanguage != null) ? originalLanguage : "";

        Page<MovieEntity> moviePage = movieRepository
                .findByGenresContainingIgnoreCaseAndOriginalLanguageContainingIgnoreCase(genreFilter, languageFilter, pageable);

        List<MovieDTO> dtoList = moviePage.getContent().stream()
                .map(MovieMapper::toDomain)
                .map(MovieMapper::toDTO)
                .collect(Collectors.toList());

        MoviePageDTO pageDTO = new MoviePageDTO();
        pageDTO.setContent(dtoList);
        pageDTO.setCurrentPage(moviePage.getNumber());
        pageDTO.setPageSize(moviePage.getSize());
        pageDTO.setTotalElements(moviePage.getTotalElements());
        pageDTO.setTotalPages(moviePage.getTotalPages());
        return pageDTO;
    }



    public List<MovieDTO> getMoviesByActorDTO(Long actorId) {
        List<Movie> movies = getMoviesByActor(actorId);
        return movies.stream()
                .map(MovieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesByActor(Long actorId) {
        return movieRepository.findByActors_Id(actorId).stream()
                .map(MovieMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getLeaderboardByGenreDTO(String genre) {
        List<Movie> movies = getLeaderboardByGenre(genre);
        return movies.stream().map(MovieMapper::toDTO).collect(Collectors.toList());
    }

    public List<Movie> getLeaderboardByGenre(String genre) {
        return movieRepository.findByGenresGenreContainingIgnoreCaseOrderByOverallRatingDesc(genre).stream()
                .map(MovieMapper::toDomain)
                .collect(Collectors.toList());
    }



}
