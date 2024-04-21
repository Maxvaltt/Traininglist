package pt1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a movement in a training program.
 */
@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movement_id")
    private Long movementId;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @OneToMany(mappedBy = "movement")
    @JsonIgnoreProperties("movement")
    private List<Training> trainings;

    /**
     * Default constructor.
     */
    public Movement() {
    }

    /**
     * Constructor with name parameter.
     *
     * @param name the name of the movement
     */
    public Movement(String name) {
        this.name = name;
    }

    /**
     * Get the movement ID.
     *
     * @return the movement ID
     */
    public Long getMovementId() {
        return movementId;
    }

    /**
     * Set the movement ID.
     *
     * @param movementId the movement ID to set
     */
    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    /**
     * Get the name of the movement.
     *
     * @return the name of the movement
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the movement.
     *
     * @param name the name of the movement to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list of trainings associated with the movement.
     *
     * @return the list of trainings
     */
    public List<Training> getTrainings() {
        return trainings;
    }

    /**
     * Set the list of trainings associated with the movement.
     *
     * @param trainings the list of trainings to set
     */
    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
