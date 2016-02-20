package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp5.domain.Order;
import pp5.respositories.OrderRepository;

/**
 * Created by Rafał on 2016-02-20.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Override
    public Order createOrder(OrderForm oderForm, String username) {
        Order order = new Order();
        return orderRepository.save(order);
    }
}
