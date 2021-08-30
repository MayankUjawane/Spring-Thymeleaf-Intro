package com.mayank.SpringThymeleafIntro.controller;

import com.mayank.SpringThymeleafIntro.model.User;
import com.mayank.SpringThymeleafIntro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("users", userService.findAll());
        // Here we are returning index because index is out View (the name of HTML file is index which is our View)
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageName", "Add");
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdateUser(@PathVariable Long id, Model model) {
        Optional user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("pageName", "Update");
            return "register";
        } else {
            return "usernotfound";
        }
    }
}
