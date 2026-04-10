
package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "Login Success (JWT can be added)";
    }
}
