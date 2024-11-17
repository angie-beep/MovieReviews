package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.DirectorEntity;

import java.util.List;

public interface DirectorDao {
    void create(DirectorEntity directorEntity);

    DirectorEntity read(long direcorId);

    void update(DirectorEntity directorEntity);

    void delete(long directorId);


}


