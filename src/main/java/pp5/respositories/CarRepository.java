package pp5.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp5.domain.Car;

/**
 * Created by Rafał on 2016-02-18.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
