package com.vitali.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping String home(){
        return "Welcome to treading platform";
    }

    @GetMapping("/api")
    public String secure() {
        return "welcome to treading platform Secure";
    }
}
