package de.moviereview.domain.service;

import de.moviereview.domain.model.Director;
import de.moviereview.infrastructure.api.mapper.DirectorMapper;
import de.moviereview.infrastructure.persistence.repository.DirectorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper ;

    public DirectorService(DirectorRepository directorRepository, DirectorMapper directorMapper ) {

        this.directorRepository = directorRepository;
        this.directorMapper = directorMapper;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll().stream()
                .map(DirectorMapper::toModel)
                .collect(Collectors.toList());
    }

    public Director getDirectorById(Long id) {
        return directorRepository.findById(id)
                .map(DirectorMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Director not found"));
    }

    public void saveDirector(Director director) {
        directorRepository.save(DirectorMapper.toEntity(director));
    }


}
