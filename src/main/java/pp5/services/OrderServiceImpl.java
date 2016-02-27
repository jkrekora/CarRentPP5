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

    @Override
    public Order createOrder(OrderForm orderForm, String username) {
        Car car = carService.getCarById(orderForm.getCarId());
        if (car == null) {
            return null;
        }
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return null;
        }
//        Calendar calendar = Calendar.getInstance();
//        java.util.Date now = calendar.getTime();
        Timestamp dateOfRent = new Timestamp(System.currentTimeMillis());
        Timestamp endDateOfRent = new Timestamp(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(orderForm.getDaysQuantity()));
        double price = car.getPrice() * orderForm.getDaysQuantity();
        Order order = new Order();
        order.setCarId(car);
        order.setUsername(user);
        order.setConfirmed(false);
        order.setDateOfRent(dateOfRent);
        order.setEndDateOfRent(endDateOfRent);
        order.setPrice(price);
        return orderRepository.save(order);
    }
}
