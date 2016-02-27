package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp5.domain.Car;
import pp5.domain.Order;
import pp5.domain.User;
import pp5.respositories.OrderRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 2016-02-20.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    DiscountService discountService;

    @Override
    public Order createOrder(OrderForm orderForm, String username) {
        Car car = carService.getCarById(orderForm.getCarId());
        if (car == null) {
            return null;
        }
        if (!carService.isAvailable(car)){
            return null;
        }
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        Timestamp dateOfRent = new Timestamp(System.currentTimeMillis());
        Timestamp endDateOfRent = new Timestamp(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(orderForm.getDaysQuantity()));
        double price = car.getPrice() * orderForm.getDaysQuantity();
        price = discountService.getPriceWithDiscount(user, orderForm.getDaysQuantity(), price);
        Order order = new Order();
        order.setCarId(car);
        order.setUsername(user);
        order.setConfirmed(false);
        order.setDateOfRent(dateOfRent);
        order.setEndDateOfRent(endDateOfRent);
        order.setPrice(price);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUsername(user);
    }


}
