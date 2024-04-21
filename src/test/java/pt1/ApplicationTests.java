package pt1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import pt1.controller.MovementController;
import pt1.domain.Movement;
import pt1.domain.MovementRepository;


@SpringBootTest
class ApplicationTests {


	@Autowired
    private MovementController movementController;

    @Autowired
    private MovementRepository movementRepository;




	@Test
	void contextLoads() throws Exception {
		assertThat(movementController).isNotNull();
	}

	//testaa toimiiko repository	
	@Test
	public void createNewMovement() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		assertThat(c.getMovementId()).isNotNull();
	}

	//testaa toimiiko repository ja palauttaako oikean tietueen 
	@Test
	public void getExistingMovement() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		Movement c2 = movementRepository.findById(c.getMovementId()).get();
		assertThat(c2.getName()).isEqualTo("Test Movement");
	}
	//palauttaa null jos ei löydy
	@Test
	public void getNonExistingMovement() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		Movement c2 = movementRepository.findById(c.getMovementId()+1).orElse(null);
		assertThat(c2).isNull();
	}
	//testaa toimiiko repository ja palauttaako oikean tietueen listaan
	@Test
	public void getAllMovements() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		List<Movement> movements = (List<Movement>) movementRepository.findAll();
		assertThat(movements).isNotEmpty();
	}

	//disabled because of the error "java.lang.AssertionError: Expecting actual not to be null"
	@Test
	public void deleteMovement() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		movementRepository.deleteById(c.getMovementId());
		Movement c2 = movementRepository.findById(c.getMovementId()).orElse(null);
		assertThat(c2).isNull();
	}

	@Test
	public void updateMovement() {
		Movement c = new Movement("Test Movement");
		movementRepository.save(c);
		c.setName("Updated Movement");
		movementRepository.save(c);
		Movement c2 = movementRepository.findById(c.getMovementId()).get();
		assertThat(c2.getName()).isEqualTo("Updated Movement");
	}

}
