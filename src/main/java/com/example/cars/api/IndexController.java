package com.example.cars.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "Cars' API";
    }

    @GetMapping("/userinfo")
    public UserDetails userDetails(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }
}