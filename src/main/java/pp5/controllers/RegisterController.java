package pp5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rafał on 2016-02-19.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String registerUserAccount() {
        return "register";
    }
}
