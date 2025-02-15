package de.moviereviews.infrastructure.api.graphql.resolver.mutation;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import de.moviereviews.infrastructure.api.dto.UserDTO;
import de.moviereviews.infrastructure.mapper.UserMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver  {

    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }
    @MutationMapping
    public UserDTO createUser(String name, String email) {

        return UserMapper.toDTO(userService.createUser(name, email));
    }
    @MutationMapping
    public UserDTO updateUser(Long id, String name, String email) {

        return UserMapper.toDTO(userService.updateUser(id, name, email));
    }
    @MutationMapping
    public Boolean deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}
