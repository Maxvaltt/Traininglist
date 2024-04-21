package pt1.controller;


import pt1.domain.Movement;
import pt1.domain.MovementRepository;


import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;

        @Controller
public class MovementController {


    
    private MovementRepository movementRepository;


    public MovementController(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    
        @GetMapping("/movementlist")
        public String showMovementList(Model model) {
            Iterable<Movement> movements = movementRepository.findAll();
            model.addAttribute("movements", movements);
            return "movementlist";
        }
        @GetMapping("/addmovement")
        public String showmovemntForm(Model model) {
            model.addAttribute("movement", new Movement());
            return "addmovement";
        }
    
       
        @PostMapping("/addmovement")
        public String addMovement(@ModelAttribute Movement newMovement, BindingResult result) {
            if(result.hasErrors()) {
                return "addmovement";
            }
            movementRepository.save(newMovement);
            return "redirect:/movementlist";
        }
    }

