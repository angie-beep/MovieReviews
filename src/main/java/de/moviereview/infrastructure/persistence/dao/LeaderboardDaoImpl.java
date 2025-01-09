package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.LeaderboardEntity;

public class LeaderboardDaoImpl extends BaseDao implements LeaderboardDao {

    @Override
    public void update(LeaderboardEntity leaderboard) {
        beginTransaction();
        em.merge(leaderboard);
        commitTransaction();
    }

    @Override
    public LeaderboardEntity read(long id) {
        return em.find(LeaderboardEntity.class, id);
    }

    @Override
    public void delete(long id) {
        beginTransaction();
        LeaderboardEntity leaderboard = em.find(LeaderboardEntity.class, id);
        if (leaderboard != null) {
            em.remove(leaderboard);
        }
        commitTransaction();
    }
}
