package pt1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pt1.domain.Movement;
import pt1.domain.MovementRepository;
import pt1.domain.Training;
import pt1.domain.TrainingRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner initData(TrainingRepository trainingRepository, MovementRepository movementRepository) {
		return (args) -> {

			// ...

			Movement pullup = new Movement("Pullup");
			Movement situp = new Movement("Situp");
			Movement benchpress = new Movement("Benchpres");
			Movement dumbbell = new Movement("Dumbbell");

			movementRepository.save(pullup);
			movementRepository.save(situp);
			movementRepository.save(benchpress);
			movementRepository.save(dumbbell);

			// ...

			Training a = new Training("rankka", "jukka", "20min", dumbbell);

			Training b = new Training("rankka", "jukka", "20min", benchpress);

			trainingRepository.save(a);
			
			trainingRepository.save(b);


		};
	}
}
