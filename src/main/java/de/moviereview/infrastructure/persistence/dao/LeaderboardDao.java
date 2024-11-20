package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.LeaderboardEntity;

import java.util.List;

public interface LeaderboardDao {

    LeaderboardEntity read(long leaderboardId);

    void update(LeaderboardEntity leaderboardEntity);

    void delete(long leaderboardId);

}
