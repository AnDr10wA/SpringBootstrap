package com.kata.security.web.security.web.controllers;

import com.kata.security.web.security.web.model.User;
import com.kata.security.web.security.web.security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String userPage(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetailsCustom = (MyUserDetails) authentication.getPrincipal();
        User user = userDetailsCustom.getUser();
        model.addAttribute(user);
        return "user";
    }
}
