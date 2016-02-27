package pp5.services;

import pp5.domain.Order;
import pp5.domain.User;

import java.util.List;

/**
 * Created by Rafał on 2016-02-20.
 */
public interface OrderService {
    Order createOrder(OrderForm oderForm, String username);
    List<Order> getUserOrders(User user);
}
