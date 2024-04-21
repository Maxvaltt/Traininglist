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

    public Training() {
    }
    

    public Training(String level, String coach, String time, Movement movement) {
        this.level = level;
        this.coach = coach;
        this.time = time;
        this.movement = movement;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getLevel() {
        return level;
    }


    public void setLevel(String level) {
        this.level = level;
    }


    public String getCoach() {
        return coach;
    }


    public void setCoach(String coach) {
        this.coach = coach;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public Movement getMovement() {
        return movement;
    }


    public void setMovement(Movement movement) {
        this.movement = movement;
    }





}


