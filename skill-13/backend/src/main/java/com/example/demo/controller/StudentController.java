package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

 private List<Map<String, Object>> students = new ArrayList<>();
 private long id = 1;

 @GetMapping
 public List<Map<String, Object>> getAll() { return students; }

 @PostMapping
 public Map<String, Object> add(@RequestBody Map<String, Object> s) {
  s.put("id", id++);
  students.add(s);
  return s;
 }
}