package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }
}
