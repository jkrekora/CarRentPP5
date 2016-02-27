package pp5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.domain.Car;
import pp5.domain.Order;
import pp5.domain.User;
import pp5.services.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by Rafał on 2016-02-19.
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("cars", carService.getFreeCars());
        return "cars";
    }

    @RequestMapping(value = "/cars/segment/{segment}", method = RequestMethod.GET)
    public String showListCarBySegment(@PathVariable String segment, Model model) {
        model.addAttribute("cars", carService.getListBySegment(segment.toUpperCase()));
        return "cars";
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public String showCarDetails(@PathVariable Integer id, Model model, OrderForm orderForm) {
        model.addAttribute("cars", carService.getCarById(id));
        return "car";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/car/{id}", method = RequestMethod.POST)
    public String reseverCar(@PathVariable Integer id, @Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/cars/";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Order order = orderService.createOrder(orderForm, username);
        if (order == null) {
            return "redirect:/cars/";
        }
        Car car = carService.getCarById(orderForm.getCarId());
        User user = userService.findUserByUsername(username);
        String redirectUrl = "https://ssl.dotpay.pl/test_payment/";
        String template = "%s?" +
                "id=%s&" +
                "amount=%s&" +
                "description=%s&" +
                "URL=%s&" +
                "control=%s&" +
                "email=%s&" +
                "type=%s&" +
                "api_version=%s";
        String url = String.format(template, redirectUrl, "744139",
                order.getPrice(),
                orderForm.getDaysQuantity()+ " dni wypozyczenia " + car.getName(),
                "http://vps247823.ovh.net/thanks/",
                order.getId(),
                user.getEmail(),
                "3",
                "dev");
        return "redirect:" + url;
    }

    @RequestMapping(value = "/payment/confirm/")
    public void confirmPayment(HashMap<String,String> req) {
        new DotpayCompletePayment(req);
    }

    @RequestMapping(value = "/thanks/")
    public String thanks() {
        return "thanks";
    }


}
