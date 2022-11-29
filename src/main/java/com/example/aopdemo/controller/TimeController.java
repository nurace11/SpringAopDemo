package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("time")
public class TimeController {
    @GetMapping
    public String time() {
        return LocalDateTime.now().toString();
    }
}
