package pp5.controllers;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.domain.Car;
import pp5.domain.Order;
import pp5.respositories.CarRepository;
import pp5.respositories.OrderRepository;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 2016-02-27.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping(value = "/resttest",method = RequestMethod.GET)
    public String testRest(){
        String redirectUrl = "https://ssl.dotpay.pl/test_payment/";
        String template = "%s?id=%s&amount=%s&description=%s&control=%s&firstname=%s&lastname=%s&email=%s";
        String adres = String.format(template, redirectUrl, "744139", "1.0", "Zaplata", "1", "rafal", "pieprzyca", "rafalPieprzyca@gmail.com");

        return adres;
    }

    @RequestMapping(value = "/reserv",method = RequestMethod.GET)
    public String carsBy(){
        Car car = carRepository.findOne(3);
        List<Order> orders = orderRepository.findByCarIdOrderByDateOfRentDesc(car);
        String answer = "nothing + ";
        List<Order> carsToRent = null;
        for (Order order : orders) {
            if (order.getDateOfRent().getTime() + TimeUnit.MINUTES.toMillis(3) < System.currentTimeMillis()) {
                // answer += order.getDateOfRent().toString() + " ";
                carsToRent.add(order);
            }
        }

        return carsToRent.toString();
    }
}
