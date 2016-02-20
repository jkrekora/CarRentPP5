package pp5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.domain.Order;
import pp5.services.CarService;
import pp5.services.OrderForm;
import pp5.services.OrderService;

import javax.validation.Valid;

/**
 * Created by Rafał on 2016-02-19.
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("cars", carService.getAll());
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
    @RequestMapping(value = "/car/{id}", method = RequestMethod.POST)
    public String reseverCar(@PathVariable Integer id, @Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/cars/";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Order order = orderService.createOrder(orderForm, username);
        return "redirect:/car/" +  id;
    }

}
