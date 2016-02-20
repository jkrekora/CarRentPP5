package pp5.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp5.domain.Order;

/**
 * Created by Rafał on 2016-02-20.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
}
