package pt1.domain;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



    @RepositoryRestResource
public interface TrainingRepository extends CrudRepository<Training, Long> {
    List<Training> findByCoach(@Param("coach") String coach);
}


