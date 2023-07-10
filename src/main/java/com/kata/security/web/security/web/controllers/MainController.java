package com.kata.security.web.security.web.controllers;


import com.kata.security.web.security.web.model.User;
import com.kata.security.web.security.web.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class MainController   {
    private MyUserDetailsService myUserDetailsService;


    @Autowired
    public void setUserService(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping("/")
    public String homePage(){
        return "Welcom to home page";
    }
//    @GetMapping("/user")
//    public String pageForAuthenticatedUsers(Principal principal){
//        User user = myUserDetailsService.findByUsername(principal.getName());
//
//
//        return "Username:  " + user.getUsername() + "</br>" + "Email : " +user.getEmail()+
//                "   " + "<a href='/logout'>Logout</a>";
//    }



}
