package pt1.controller;

import pt1.domain.Movement;
import pt1.domain.MovementRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The MovementController class is responsible for handling HTTP requests
 * related to movements.
 */
@Controller
public class MovementController {
    private MovementRepository movementRepository;

    /**
     * Constructs a MovementController object with the specified MovementRepository.
     * 
     * @param movementRepository the repository for accessing movement data
     */
    public MovementController(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    /**
     * Retrieves a list of movements and adds it to the model.
     * 
     * @param model the model object to add the movements to
     * @return the view name for displaying the movement list
     */
    @GetMapping("/movementlist")
    public String showMovementList(Model model) {
        Iterable<Movement> movements = movementRepository.findAll();
        model.addAttribute("movements", movements);
        return "movementlist";
    }

    /**
     * Displays the form for adding a new movement.
     * 
     * @param model the model object to add the new movement to
     * @return the view name for displaying the add movement form
     */
    @GetMapping("/addmovement")
    public String showmovementForm(Model model) {
        model.addAttribute("movement", new Movement());
        return "addmovement";
    }

    /**
     * Adds a new movement to the repository.
     * 
     * @param newMovement the new movement to be added
     * @param result      the binding result for validating the new movement
     * @return the view name for redirecting to the movement list
     */
    @PostMapping("/addmovement")
    public String addMovement(@ModelAttribute Movement newMovement, BindingResult result) {
        if (result.hasErrors()) {
            return "addmovement";
        }
        movementRepository.save(newMovement);
        return "redirect:/movementlist";
    }
}
