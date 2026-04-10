package com.example.authdemo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    private Map<String, String> users = new HashMap<>();

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> data) {
        users.put(data.get("username"), data.get("password"));
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data) {
        String user = data.get("username");
        String pass = data.get("password");

        if (users.containsKey(user) && users.get(user).equals(pass)) {
            return user;
        }
        return "Invalid";
    }

    @GetMapping("/profile/{username}")
    public Map<String, String> profile(@PathVariable String username) {
        Map<String, String> res = new HashMap<>();
        res.put("username", username);
        res.put("email", username + "@mail.com");
        return res;
    }
}
