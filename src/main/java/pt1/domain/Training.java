package pt1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

/**
 * Represents a training session.
 */
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Level is required")
    private String level;

    @NotBlank(message = "Coach name is required")
    private String coach;

    @NotBlank(message = "Time is required")
    @Column(nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "movement_id")
    @JsonIgnoreProperties("training")
    private Movement movement;

    /**
     * Default constructor for the Training class.
     */
    public Training() {
    }

    /**
     * Constructor for the Training class.
     * 
     * @param level    The level of the training.
     * @param coach    The name of the coach.
     * @param time     The time of the training.
     * @param movement The movement associated with the training.
     */
    public Training(String level, String coach, String time, Movement movement) {
        this.level = level;
        this.coach = coach;
        this.time = time;
        this.movement = movement;
    }

    /**
     * Get the ID of the training.
     * 
     * @return The ID of the training.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the training.
     * 
     * @param id The ID of the training.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the level of the training.
     * 
     * @return The level of the training.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Set the level of the training.
     * 
     * @param level The level of the training.
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Get the coach name of the training.
     * 
     * @return The coach name of the training.
     */
    public String getCoach() {
        return coach;
    }

    /**
     * Set the coach name of the training.
     * 
     * @param coach The coach name of the training.
     */
    public void setCoach(String coach) {
        this.coach = coach;
    }

    /**
     * Get the time of the training.
     * 
     * @return The time of the training.
     */
    public String getTime() {
        return time;
    }

    /**
     * Set the time of the training.
     * 
     * @param time The time of the training.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Get the movement associated with the training.
     * 
     * @return The movement associated with the training.
     */
    public Movement getMovement() {
        return movement;
    }

    /**
     * Set the movement associated with the training.
     * 
     * @param movement The movement associated with the training.
     */
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}
