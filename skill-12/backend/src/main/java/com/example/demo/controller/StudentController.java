package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

 private final StudentService service;

 public StudentController(StudentService service) {
  this.service = service;
 }

 @GetMapping
 public List<Student> getAll() { return service.getAll(); }

 @PostMapping
 public Student add(@RequestBody Student s) { return service.add(s); }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Long id) { service.delete(id); }
}