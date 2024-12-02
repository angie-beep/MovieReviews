package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.infrastructure.persistence.entity.DirectorEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectorRepository {
    private final List<DirectorEntity> directors = new ArrayList<>();

    public List<DirectorEntity> findAll() {
        return directors;
    }

    public Optional<DirectorEntity> findById(Long id) {
        return directors.stream().filter(director -> director.getId().equals(id)).findFirst();
    }

    public void save(DirectorEntity director) { directors.add(director);}
}