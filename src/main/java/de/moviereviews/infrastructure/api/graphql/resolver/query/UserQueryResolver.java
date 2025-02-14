package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
