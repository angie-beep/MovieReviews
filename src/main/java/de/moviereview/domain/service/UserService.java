package de.moviereview.domain.service;

import de.moviereview.domain.model.User;
import de.moviereview.infrastructure.api.mapper.UserMapper;
import de.moviereview.infrastructure.persistence.entity.UserEntity;
import de.moviereview.infrastructure.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Constructor
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Find a user by ID
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toModel); // Convert UserEntity to User
    }

    // Find all users
    public List<User> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toModel) // Convert each UserEntity to User
                .collect(Collectors.toList());
    }

    // Create or update a user
    public User saveUser(String name, String email) {
        UserEntity savedEntity = userRepository.save(userMapper.toEntity(user)); // Convert User to UserEntity
        return userMapper.toModel(savedEntity); // Convert back to User
    }

    // Delete a user by ID
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toModel)
                .collect(Collectors.toList());
    }


}

