package de.moviereview.infrastructure.persistence.dao;
import de.moviereview.infrastructure.persistence.entity.LeaderboardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LeaderboardDaoImpl implements LeaderboardDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();


    public void delete(long id) {
        em.getTransaction().begin();
        LeaderboardEntity leaderboard = em.find(LeaderboardEntity.class, id);
        if (leaderboard != null) {
            em.remove(leaderboard);
        }
        em.getTransaction().commit();
    }

    public LeaderboardEntity read(long id) {
        final LeaderboardEntity result = em.find(LeaderboardEntity.class, id);
        return result;
    }

    public void update(LeaderboardEntity leaderboard){
    }

    public void close() {
        em.close();
        emf.close();
    }
}
