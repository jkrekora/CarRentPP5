package pp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp5.domain.Order;
import pp5.domain.User;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 2016-02-27.
 */
@Service
public class DiscountService {
    @Autowired
    private OrderService orderService;

    public double getPriceWithDiscount(User user, int days, double price) {
        return price - (price * (calculateDiscountValue(user, days)/100));
    }

    private double calculateDiscountValue(User user, int days) {
        if (discount1(user)) return 30.0;
        if (discount2(days)) return 20.0;
        return 0;
    }

    private boolean discount1(User user) {
        List<Order> orders = orderService.getUserOrders(user);
        if (orders == null){
            return false;
        }
        int count = 0;
        for (Order order : orders) {
            if (order.isConfirmed()) {
                if (inLastMonth(order)){ count++;}
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    private boolean inLastMonth(Order order) {
        return order.getDateOfRent().getTime() > System.currentTimeMillis() - TimeUnit.DAYS.toMillis(30);
    }

    private boolean discount2(int days) {
        if (days >= 7) return true;
        return false;
    }
}
