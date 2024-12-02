package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.ActorEntity;
import de.moviereview.infrastructure.persistence.entity.DirectorEntity;

import java.util.List;

public interface DirectorDao {
    void create( DirectorEntity directorEntity );

    DirectorEntity read( long directorId );

    //void updateFirstname(String firstname);
    //void updateLastname(String lastname);

    void delete( long directorId );
}


