package pt1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a user in the system.
 */
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructs a User object with the specified username, password hash, and
     * role.
     * 
     * @param username     The username of the user.
     * @param passwordHash The password hash of the user.
     * @param role         The role of the user.
     */
    public User(String username, String passwordHash, String role) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    /**
     * Returns the ID of the user.
     * 
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * 
     * @param id The ID of the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username of the user.
     * 
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password hash of the user.
     * 
     * @return The password hash of the user.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets the password hash of the user.
     * 
     * @param passwordHash The password hash of the user.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Returns the role of the user.
     * 
     * @return The role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * 
     * @param role The role of the user.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
