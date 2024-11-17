package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;

import java.util.List;

public interface ActorDao {
    void create( ActorEntity actorEntity );

    ActorEntity read( long actorId );

    void update( ActorEntity actorEntity );

    void delete( long actorId );


}
