package pt1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt1.domain.Training;
import pt1.domain.TrainingRepository;

/**
 * This class represents a REST controller for managing trainings.
 */
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class TrainingRestController {

    @Autowired
    private TrainingRepository trainingRepository;

    /**
     * Retrieves all trainings.
     *
     * @return A list of all trainings.
     */
    @RequestMapping(value = "/trainings", method = RequestMethod.GET)
    public @ResponseBody List<Training> getTrainingsRest() {
        return (List<Training>) trainingRepository.findAll();
    }

    /**
     * Retrieves a training by its ID.
     *
     * @param trainingId The ID of the training to retrieve.
     * @return The training with the specified ID, or an empty optional if not
     *         found.
     */
    @RequestMapping(value = "/trainings/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Training> getTrainingByIdRest(@PathVariable("id") Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    /**
     * Adds a new training.
     *
     * @param training The training to add.
     * @return The added training with HTTP status code 201 (Created).
     */
    @RequestMapping(value = "api/trainings", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Training> addTrainingRest(@RequestBody Training training) {
        Training newTraining = trainingRepository.save(training);
        return new ResponseEntity<>(newTraining, HttpStatus.CREATED);
    }

}
