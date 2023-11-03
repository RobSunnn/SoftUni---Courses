package com.plannerapp.controller;

import com.plannerapp.model.dto.UserLoginDTO;
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
public class UserLoginController {

    private final UserService userService;

    private final LoggedUser loggedUser;

    public UserLoginController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("UserLoginDTO") UserLoginDTO userLoginDTO) {
        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("UserLoginDTO")
                              @Valid UserLoginDTO userLoginDTO,
                              BindingResult bindingResult) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        boolean isLoginSuccessful = userService.loginUser(userLoginDTO);

        if (!isLoginSuccessful) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("errors", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/logout")
    public ModelAndView logout() {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        userService.logout();

        return new ModelAndView("redirect:/");
    }
}
