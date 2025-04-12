package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalariesController {
    @RequestMapping("/")
    public String index(){
        return "votre controller SalariesController.js est bien implémenter";
    }
}
