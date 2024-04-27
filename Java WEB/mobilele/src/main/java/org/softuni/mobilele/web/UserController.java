package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
//    @PreAuthorize("isAnonymous()")
    public ModelAndView login() {
        return new ModelAndView("auth-login");
    }

    @PostMapping("/login-error")
    public String onFailure(@ModelAttribute("email") String email,
            Model model) {
        // we add attribute email to stay on the field if there is an error
        model.addAttribute("email", email);
        // we add bad_credentials so spring and thymeleaf know that there is something wrong
        // and message appears below the fields
        model.addAttribute("bad_credentials", "true");

        return "auth-login";
    }


    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterDTO")
                                     UserRegisterDTO userRegisterDTO) {

        return new ModelAndView("auth-register");
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userRegisterDTO")
                           @Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "auth-register";
        }

        this.userService.registerUser(userRegisterDTO);

        return "redirect:/users/login";
    }

}
