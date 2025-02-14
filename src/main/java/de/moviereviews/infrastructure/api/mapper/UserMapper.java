package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setEmail(entity.getEmail());
        return user;
    }
}
