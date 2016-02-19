package pp5.respositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pp5.domain.Car;

import java.util.List;

/**
 * Created by Rafał on 2016-02-18.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findBySegment(String segment);

    List<Car> findByIdLessThan(int id);
}
