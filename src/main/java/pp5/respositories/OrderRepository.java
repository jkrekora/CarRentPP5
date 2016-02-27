package pp5.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp5.domain.Car;
import pp5.domain.Order;

import java.util.List;

/**
 * Created by Rafał on 2016-02-20.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByCarIdOrderByDateOfRentDesc(Car car);
    List<Order> findByCarIdOrderByEndDateOfRentDesc(Car car);
}
