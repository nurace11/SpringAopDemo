package com.example.aopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InteractiveController {
    @GetMapping
    public String main() {
        System.out.println("main");
        return "templates/main.html";
    }

    @GetMapping("/kek")
    public String kek() {
        System.out.println("kek");
        return "static/kek.html";
    }
}
