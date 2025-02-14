package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Director;
import de.moviereviews.infrastructure.api.mapper.DirectorMapper;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import de.moviereviews.infrastructure.persistence.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorService {
@Autowired
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    // Liefert alle Regisseure als Domain-Objekte
    public List<Director> getAllDirectors() {
        return directorRepository.findAll().stream()
                .map(DirectorMapper::toDomain)
                .collect(Collectors.toList());
    }

    // Liefert einen Regisseur anhand der ID
    public Director getDirectorById(Long id) {
        return directorRepository.findById(id) .map(DirectorMapper::toDomain) .orElseThrow(() -> new NotFoundException("Director with id " + id + " not found"));
    }

    // Fügt einen neuen Regisseur hinzu
    public Director addDirector(String firstName, String lastName, String birthday, String heritage) {
        DirectorEntity entity = new DirectorEntity();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        if (birthday != null && !birthday.isEmpty()) {
            entity.setBirthday(LocalDate.parse(birthday));
        }
        entity.setHeritage(heritage);
        DirectorEntity saved = directorRepository.save(entity);
        return DirectorMapper.toDomain(saved);
    }
}
