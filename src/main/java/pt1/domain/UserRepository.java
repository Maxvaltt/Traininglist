package pt1.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * The UserRepository interface represents a repository for managing User
 * entities.
 * It extends the CrudRepository interface, which provides basic CRUD operations
 * for User entities.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find.
     * @return The User object with the specified username, or null if not found.
     */
    User findByUsername(String username);
}
