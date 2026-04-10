package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Add a new student")
    @ApiResponse(responseCode = "200", description = "Student created")
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return repo.findById(id).map(student -> {
            student.setName(s.getName());
            student.setEmail(s.getEmail());
            student.setCourse(s.getCourse());
            return ResponseEntity.ok(repo.save(student));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
