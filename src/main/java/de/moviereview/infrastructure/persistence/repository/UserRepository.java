package de.moviereview.infrastructure.persistence.repository;
import de.moviereview.domain.model.User;
import java.util.ArrayList;
import java.util.*;
import java.util.Optional;
public class UserRepository {
    private final Map<Long, User> userStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create or update a user
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
        }
        userStorage.put(user.getId(), user);
        return user;
    }

    // Find a user by ID
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStorage.get(id));
    }

    // Get all users
    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    // Delete a user by ID
    public boolean deleteById(Long id) {
        return userStorage.remove(id) != null;
    }

    // Check if a user exists by ID
    public boolean existsById(Long id) {
        return userStorage.containsKey(id);
    }
}
