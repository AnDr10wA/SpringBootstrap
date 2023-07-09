package com.kata.security.web.security.web.controllers;


import com.kata.security.web.security.web.model.User;
import com.kata.security.web.security.web.services.UserDetailServiceImpl;
import com.kata.security.web.security.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping
public class MainController   {
    private UserDetailServiceImpl userDetailServiceImpl;


    @Autowired
    public void setUserService(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

    @GetMapping("/")
    public String homePage(){
        return "Welcom to home page";
    }
    @GetMapping("/user")
    public String pageForAuthenticatedUsers(Principal principal){
        User user = userDetailServiceImpl.findByUsername(principal.getName());


        return "Username:  " + user.getUsername() + "</br>" + "Email : " +user.getEmail()+
                "   " + "<a href='/logout'>Logout</a>";
    }



}
