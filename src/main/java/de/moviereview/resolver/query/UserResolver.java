package de.moviereview.resolver.query;

import de.moviereview.domain.model.User;
import de.moviereview.infrastructure.persistence.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class UserResolver implements GraphQLQueryResolver {

    private final UserRepository userRepository = new UserRepository();

    // Fetch a User by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    // Fetch all Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
