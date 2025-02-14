package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    public User createUser(String name, String email) {
        return userService.createUser(name, email);
    }

    public User updateUser(Long id, String name, String email) {
        return userService.updateUser(id, name, email);
    }

    public Boolean deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}
