package pp5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pp5.domain.User;
import pp5.services.PersonForm;
import pp5.services.UserService;
import pp5.validation.UserExistsException;

import javax.validation.Valid;

/**
 * Created by Rafał on 2016-02-19.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm(PersonForm personForm) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUserAccount(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User user = createNewUser(personForm);
        if (user == null) {
            model.addAttribute("loginAlreadyUsed", "Login is already used!");
            return "register";
        }
        return "registerConfirm";
    }

    private User createNewUser(PersonForm personForm) {
        User user = null;
        try {
            user = userService.registerNewUserAccount(personForm);
        } catch (UserExistsException e) {
        }
        return user;
    }
}
