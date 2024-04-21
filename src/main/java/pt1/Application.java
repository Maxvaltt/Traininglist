package pt1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pt1.domain.Movement;
import pt1.domain.MovementRepository;
import pt1.domain.Training;
import pt1.domain.TrainingRepository;
import pt1.domain.User;
import pt1.domain.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner initData(TrainingRepository trainingRepository, MovementRepository movementRepository, UserRepository userRepository) {
		return (args) -> {

			// ajaa liiketietokantaan

			Movement pullup = new Movement("Pullup");
			Movement situp = new Movement("Situp");
			Movement benchpress = new Movement("Benchpres");
			Movement dumbbell = new Movement("Dumbbell");

			movementRepository.save(pullup);
			movementRepository.save(situp);
			movementRepository.save(benchpress);
			movementRepository.save(dumbbell);

			// ajaa treenitietokantaan

			Training a = new Training("kevyt", "jukka", "20min", dumbbell);
			Training b = new Training("rankka", "jukka", "20min", benchpress);

			trainingRepository.save(a);
			trainingRepository.save(b);

			// ajaa käyttäjätietokantaan

			User user1 = new User("user","$2a$10$lUD01taj9kl.VQo1LaUqNOds/4gMn3PYEXC4ymukKFOLqWlxGoG3a", "USER");
			User user2 = new User("admin","$2a$10$SxLPHuXQMZt//Otx9tv6VukJjb8.vKyOVgTpGBmoCGWAmv8pNqHG6","ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

		};
	}
}
