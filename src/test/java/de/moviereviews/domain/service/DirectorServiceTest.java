package de.moviereviews.domain.service;

import de.moviereviews.domain.exceptions.NotFoundException;
import de.moviereviews.domain.model.Director;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import de.moviereviews.infrastructure.persistence.repository.DirectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService directorService;

    private DirectorEntity directorEntity1;
    private DirectorEntity directorEntity2;

    @BeforeEach
    void setUp() {
        directorEntity1 = new DirectorEntity();
        directorEntity1.setId(1L);
        directorEntity1.setFirstName("Christopher");
        directorEntity1.setLastName("Nolan");
        directorEntity1.setBirthday(LocalDate.of(1970, 7, 30));
        directorEntity1.setHeritage("British");

        directorEntity2 = new DirectorEntity();
        directorEntity2.setId(2L);
        directorEntity2.setFirstName("Steven");
        directorEntity2.setLastName("Spielberg");
        directorEntity2.setBirthday(LocalDate.of(1946, 12, 18));
        directorEntity2.setHeritage("American");
    }

    @Test
    void testGetAllDirectors() {
        // Arrange
        when(directorRepository.findAll()).thenReturn(Arrays.asList(directorEntity1, directorEntity2));

        // Act
        List<Director> directors = directorService.getAllDirectors();

        // Assert
        assertNotNull(directors);
        assertEquals(2, directors.size());
        assertEquals("Christopher", directors.get(0).getFirstName());
        assertEquals("Steven", directors.get(1).getFirstName());
        verify(directorRepository, times(1)).findAll();
    }

    @Test
    void testGetDirectorById_Found() {
        // Arrange
        when(directorRepository.findById(1L)).thenReturn(Optional.of(directorEntity1));

        // Act
        Director director = directorService.getDirectorById(1L);

        // Assert
        assertNotNull(director);
        assertEquals("Christopher", director.getFirstName());
        verify(directorRepository, times(1)).findById(1L);
    }

    @Test
    void testGetDirectorById_NotFound() {
        // Arrange
        when(directorRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> directorService.getDirectorById(99L));
        assertEquals("Director with id 99 not found", thrown.getMessage());
        verify(directorRepository, times(1)).findById(99L);
    }

    @Test
    void testAddDirector_WithBirthday() {
        // Arrange
        DirectorEntity savedEntity = new DirectorEntity();
        savedEntity.setId(3L);
        savedEntity.setFirstName("Quentin");
        savedEntity.setLastName("Tarantino");
        savedEntity.setBirthday(LocalDate.of(1963, 3, 27));
        savedEntity.setHeritage("American");

        when(directorRepository.save(any(DirectorEntity.class))).thenReturn(savedEntity);

        // Act
        Director director = directorService.addDirector("Quentin", "Tarantino", "1963-03-27", "American");

        // Assert
        assertNotNull(director);
        assertEquals("Quentin", director.getFirstName());
        assertEquals(LocalDate.of(1963, 3, 27), director.getBirthday());
        verify(directorRepository, times(1)).save(any(DirectorEntity.class));
    }

    @Test
    void testAddDirector_WithoutBirthday() {
        // Arrange
        DirectorEntity savedEntity = new DirectorEntity();
        savedEntity.setId(4L);
        savedEntity.setFirstName("Francis");
        savedEntity.setLastName("Coppola");
        savedEntity.setHeritage("American");

        when(directorRepository.save(any(DirectorEntity.class))).thenReturn(savedEntity);

        // Act
        Director director = directorService.addDirector("Francis", "Coppola", "", "American");

        // Assert
        assertNotNull(director);
        assertEquals("Francis", director.getFirstName());
        assertNull(director.getBirthday());
        verify(directorRepository, times(1)).save(any(DirectorEntity.class));
    }
}