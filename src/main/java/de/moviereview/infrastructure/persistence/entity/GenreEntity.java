package de.moviereview.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_movie",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<MovieEntity> movies;

    public GenreEntity(){}

    public GenreEntity(Long id, String genre, Set<MovieEntity> movies) {
        this.id = id;
        this.genre = genre;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
    }
}
