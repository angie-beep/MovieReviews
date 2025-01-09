package de.moviereview.resolver.query;

import de.moviereview.domain.model.User;
import de.moviereview.domain.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.Optional;

public class UserResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    // Fetch a User by ID
    public Optional<User> getUserById(Long id) {
        return userService.findUserById(id);
    }

    // Fetch all Users
    public List<User> getAllUsers() {

        return userService.findAll();
    }
}
