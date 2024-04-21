package pt1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import pt1.domain.MovementRepository;
import pt1.domain.Training;
import pt1.domain.TrainingRepository;

/**
 * The TrainingController class is responsible for handling HTTP requests related to training operations.
 * It provides methods for displaying training lists, adding new trainings, deleting trainings, and updating trainings.
 */
/**
 * Controller class for managing training related operations.
 */
@Controller
public class TrainingController {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private MovementRepository movementRepository;

    /**
     * Retrieves the list of trainings and displays them in the traininglist view.
     *
     * @param model the model object for passing data to the view
     * @return the name of the view to render
     */
    @GetMapping("/traininglist")
    public String showTrainingList(Model model) {
        Iterable<Training> trainings = trainingRepository.findAll();
        model.addAttribute("trainings", trainings);
        return "traininglist";
    }

    /**
     * Displays the form for adding a new training.
     *
     * @param model the model object for passing data to the view
     * @return the name of the view to render
     */
    @GetMapping("/addtraining")
    public String showAddTrainingForm(Model model) {
        model.addAttribute("training", new Training());
        model.addAttribute("movements", movementRepository.findAll());
        return "addtraining";
    }

    /**
     * Adds a new training to the database.
     *
     * @param newTraining the new training object to be added
     * @param result      the binding result object for validation errors
     * @param model       the model object for passing data to the view
     * @return the name of the view to render
     */
    @PostMapping("/addtraining")
    public String addTraining(@Valid @ModelAttribute Training newTraining, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movements", movementRepository.findAll());
            return "addtraining";
        }

        trainingRepository.save(newTraining);
        return "redirect:/traininglist";
    }

    /**
     * Deletes a training from the database.
     *
     * @param id the ID of the training to be deleted
     * @return the name of the view to render
     */
    @GetMapping("/deletetraining/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTraining(@PathVariable Long id) {
        trainingRepository.deleteById(id);
        return "redirect:/traininglist";
    }

    /**
     * Displays the form for editing an existing training.
     *
     * @param id    the ID of the training to be edited
     * @param model the model object for passing data to the view
     * @return the name of the view to render
     */
    @GetMapping("/edittraining/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditTrainingForm(@PathVariable Long id, Model model) {
        Optional<Training> optionalTraining = trainingRepository.findById(id);
        if (optionalTraining.isPresent()) {
            model.addAttribute("training", optionalTraining.get());
            model.addAttribute("movements", movementRepository.findAll());
            return "edittraining";
        } else {
            return "redirect:/traininglist";
        }
    }

    /**
     * Updates an existing training in the database.
     *
     * @param updatedTraining the updated training object
     * @param result          the binding result object for validation errors
     * @param model           the model object for passing data to the view
     * @return the name of the view to render
     */
    @PostMapping("/updatetraining")
    public String updateTraining(@Valid @ModelAttribute @NonNull Training updatedTraining, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movements", movementRepository.findAll());
            return "edittraining";
        }
        trainingRepository.save(updatedTraining);
        return "redirect:/traininglist";
    }
}
