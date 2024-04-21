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

}
