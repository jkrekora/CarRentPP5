package pp5.controllers;

import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.services.CarService;
import pp5.services.OrderForm;

/**
 * Created by Rafał on 2016-02-19.
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;

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

}
