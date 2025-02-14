package de.moviereviews.domain.service;

import de.moviereviews.domain.model.User;
import de.moviereviews.infrastructure.mapper.UserMapper;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;
import de.moviereviews.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserService {
@Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        UserEntity entity = new UserEntity();
        entity.setUsername(name);
        entity.setEmail(email);
        UserEntity saved = userRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    public User updateUser(Long id, String name, String email) {
        Optional<UserEntity> entityOpt = userRepository.findById(id);
        if (!entityOpt.isPresent()) {
            return null;
        }
        UserEntity entity = entityOpt.get();
        if (name != null) {
            entity.setUsername(name);
        }
        if (email != null) {
            entity.setEmail(email);
        }
        UserEntity saved = userRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User getUserById(Long id) {
        Optional<UserEntity> entityOpt = userRepository.findById(id);
        return entityOpt.map(UserMapper::toDomain).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }
}
