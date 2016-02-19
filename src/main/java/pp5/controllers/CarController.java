package pp5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.services.CarService;

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
    public String showSegmentA(@PathVariable String segment, Model model) {
        model.addAttribute("cars", carService.getListBySegment(segment.toUpperCase()));
        return "cars";
    }
}
