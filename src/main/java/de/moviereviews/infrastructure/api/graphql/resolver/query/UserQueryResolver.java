package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Review;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import de.moviereviews.infrastructure.mapper.UserMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.User;
import de.moviereviews.domain.service.UserService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import de.moviereviews.infrastructure.api.dto.UserDTO;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public UserDTO getUserById(Long id) {

        return UserMapper.toDTO(userService.getUserById(id));
    }

    public List<UserDTO> getAllUsers() {
        List<User> user = userService.getAllUsers();
        return  user.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
