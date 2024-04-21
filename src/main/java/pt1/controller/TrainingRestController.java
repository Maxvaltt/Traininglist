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

    
    



    @CrossOrigin
    @Controller
public class TrainingRestController {
  




    
        @Autowired
        private TrainingRepository trainingRepository;
    
        @RequestMapping(value="/trainings", method = RequestMethod.GET)
        public @ResponseBody List<Training> getBooksRest() {
            return (List<Training>) trainingRepository.findAll();
        }
    
        
        @RequestMapping(value="/trainings/{id}", method = RequestMethod.GET)
        public @ResponseBody Optional<Training> getBookByIdRest(@PathVariable("id") Long bookId) {
            return trainingRepository.findById(bookId);
        }
        
        @RequestMapping(value="/trainings", method = RequestMethod.POST)
        public @ResponseBody ResponseEntity<Training> addTrainingRest(@RequestBody Training training) {
            Training newTraining = trainingRepository.save(training);
            return new ResponseEntity<>(newTraining, HttpStatus.CREATED);
        }
    
    }
    
