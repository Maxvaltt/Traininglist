package pt1.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestController
public interface MovementRepository extends CrudRepository<Movement, Long> {

    
}

