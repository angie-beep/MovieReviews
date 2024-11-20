package de.moviereview.infrastructure.persistence.dao;

//abstraction layer for interacting with the database, encapsulating query logic and raw data operations for actors.

import de.moviereview.infrastructure.persistence.entity.ActorEntity;

import java.util.List;

public interface ActorDao {
    void create( ActorEntity actorEntity );

    ActorEntity read( long actorId );

    void updateFirstname(String firstname);
    void updateLastname(String lastname);

    void delete( long actorId );


}
