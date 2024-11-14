package de.moviereview.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import de.moviereview.domain.model.Movie;

import java.util.List;
//Für Verbindug zu Datenbank... glaube ich
public class MovieRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager entityManager = emf.createEntityManager();
    //der Entity Manager ist für CRUD Operationen.........glaube ich
    public List<Movie> findAll() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    //jede DB-operation beginnt mit begin und endet mit commit
    //Hier für neuen Movie in die DB saven
    public Movie save(Movie movie) {
        entityManager.getTransaction().begin();
        if (movie.getId() == null) {
            entityManager.persist(movie);
        } else {
            movie = entityManager.merge(movie);
        }
        entityManager.getTransaction().commit();
        return movie;
    }
    //zum löschen
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class, id);
        if (movie != null) {
            entityManager.remove(movie);
        }
        entityManager.getTransaction().commit();
    }
    //aubrufen
    public Movie findById(Long id) {
        return entityManager.find(Movie.class, id);
    }
    //schließt den entity manager
    public void close() {
        entityManager.close();
        emf.close();
    }
}
