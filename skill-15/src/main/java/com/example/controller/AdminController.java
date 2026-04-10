
package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String add() {
        return "Admin Add Success";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Admin Delete Success";
    }
}
