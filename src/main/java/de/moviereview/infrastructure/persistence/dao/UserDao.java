package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.UserEntity;

import java.util.List;

public interface UserDao {
    void create(UserEntity userEntity);

    UserEntity read(long userId);

   // void updateUsername(String name);
   // void updateEmail(String email);
    //void updateNotificaations();


    void delete(long userId);

}
