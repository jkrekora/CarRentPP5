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
        }//jakies factory zbudowac
        String redirectUrl = "https://ssl.dotpay.pl/test_payment/";
        String template = "%s?id=%s&amount=%s&description=%s&control=%s&email=%s";
        String adres = String.format(template, redirectUrl, "744139",
                order.getPrice(),
                orderForm.getDaysQuantity()+ " dni wypozyczenia " + " nazwa",
                order.getId(),
                "rafalPieprzyca@gmail.com");
        return "redirect:" + adres;
    }

    @RequestMapping(value = "/payment/confirm", method = RequestMethod.POST)
    public void confirmPayment() {
        System.out.println("confirm");
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String doPayment(Model model) {
        String redirectUrl = "https://ssl.dotpay.pl/test_payment/";
        String template = "%s?id=%s&amount=%s&description=%s&control=%s&firstname=%s&lastname=%s&email=%s";
        String adres = String.format(template, redirectUrl, "744139", "1.0", "Zaplata", "1", "rafal", "pieprzyca", "rafalPieprzyca@gmail.com");
        return "redirect:" + adres;
    }
    //https://ssl.dotpay.pl/test_payment/?id=744139
    // &amount=1.0
    // &description=Zaplata
    // &control=25-01-2016&
    // firstname=rafal
    // &lastname=pieprzyca
    // &email=rafalpieprzyca@gmail.com

}
