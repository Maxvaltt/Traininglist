package pt1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class TrainingController {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private MovementRepository movementRepository;



    @GetMapping("/traininglist")
    public String showTrainingList(Model model) {
        Iterable<Training> trainings = trainingRepository.findAll();
        model.addAttribute("trainings", trainings);
        return "traininglist";
    }

    @GetMapping("/addtraining")
    public String showAddTrainingForm(Model model) {
        model.addAttribute("training", new Training());
        model.addAttribute("movements", movementRepository.findAll());
        return "addtraining";
    }

   
    @PostMapping("/addtraining")
    public String addTraining(@Valid @ModelAttribute Training newTraining, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movements", movementRepository.findAll());
            return "addtraining";
        }

        trainingRepository.save(newTraining);
        return "redirect:/traininglist";
    }

    @GetMapping("/deletetraining/{id}")
    public String deleteTraining(@PathVariable Long id) {
        trainingRepository.deleteById(id);
        return "redirect:/traininglist";
    }

    @GetMapping("/edittraining/{id}")

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

    @PostMapping("/updatetraining")
    public String updateTraining(@Valid @ModelAttribute @NonNull Training updatedTraining, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movements", movementRepository.findAll());
            return "edittraining";
        }        
        trainingRepository.save(updatedTraining);
        return "redirect:/traininglist";
    }
}
