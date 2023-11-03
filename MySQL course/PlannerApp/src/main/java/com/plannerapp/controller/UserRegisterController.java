package com.plannerapp.controller;

import com.plannerapp.model.dto.UserRegisterDTO;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserRegisterController {

    private final UserService userService;

    private final LoggedUser loggedUser;


    public UserRegisterController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterDTO") UserRegisterDTO userRegisterDTO) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterDTO")
                                 @Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");

        }

        boolean registrationSuccessful = userService.registerUser(userRegisterDTO);

        if(!registrationSuccessful) {
            return new ModelAndView("register");
        }
        return new ModelAndView("redirect:/login");
    }

}
