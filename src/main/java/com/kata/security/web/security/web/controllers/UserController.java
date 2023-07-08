package com.kata.security.web.security.web.controllers;

import com.kata.security.web.security.web.model.User;
import com.kata.security.web.security.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/show")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }
    @GetMapping("/create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id")  Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("update/{id}")
    public String updateUserForm(@PathVariable("id")  Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

}
