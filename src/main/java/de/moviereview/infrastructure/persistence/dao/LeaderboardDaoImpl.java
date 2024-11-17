package de.moviereview.infrastructure.persistence.dao;
import de.moviereview.infrastructure.persistence.entity.LeaderboardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LeaderboardDaoImpl {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public void delete(Long id) {
        em.getTransaction().begin();
        LeaderboardEntity leaderboard = em.find(LeaderboardEntity.class, id);
        if (leaderboard != null) {
            em.remove(leaderboard);
        }
        em.getTransaction().commit();
    }

    public LeaderboardEntity read(Long id) {
        final LeaderboardEntity result = em.find(LeaderboardEntity.class, id);
        return result;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
