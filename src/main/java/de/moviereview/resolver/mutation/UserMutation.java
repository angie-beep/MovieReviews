package de.moviereview.resolver.mutation;
import de.moviereview.infrastructure.api.dto.UserDTO;
import de.moviereview.domain.model.User;
import de.moviereview.domain.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService ;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }


    // Create a new User
    public User createUser(String name, String email) {
        return userService.saveUser(User);
    }

    // Update an existing User
    public User updateUser(UserDTO userInput) {
        User user = userRepository.findById(userInput.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userInput.getId()));

        if (userInput.getUsername() != null && !userInput.getUsername().isEmpty()) {
            user.setUsername(userInput.getUsername());
        }
        if (userInput.getEmail() != null && !userInput.getEmail().isEmpty()) {
            user.setEmail(userInput.getEmail());
        }

        return userRepository.save(user);
    }

    // Delete a User
    public Boolean deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        userRepository.deleteById(user.getId());
        return true;
    }
}
