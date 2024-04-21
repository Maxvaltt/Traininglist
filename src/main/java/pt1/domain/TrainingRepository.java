package pt1.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This interface represents a repository for managing Training entities.
 * It extends the CrudRepository interface, providing basic CRUD operations for
 * Training entities.
 */
@RepositoryRestResource
public interface TrainingRepository extends CrudRepository<Training, Long> {

    /**
     * Retrieves a list of Training entities based on the specified coach.
     *
     * @param coach the coach name to search for
     * @return a list of Training entities matching the specified coach
     */
    List<Training> findByCoach(@Param("coach") String coach);
}
