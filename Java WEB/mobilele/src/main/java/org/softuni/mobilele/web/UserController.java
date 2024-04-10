package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("auth-login");
    }


    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO userLoginDTO) {

        userService.loginUser(userLoginDTO);

        return new ModelAndView("redirect:/");
    }


    @GetMapping("/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }


    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("auth-register");
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO) {

        this.userService.registerUser(userRegisterDTO);

        return "redirect:/users/login";
    }

}
