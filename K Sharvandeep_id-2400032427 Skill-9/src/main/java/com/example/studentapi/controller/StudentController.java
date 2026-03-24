
package com.example.studentapi.controller;

import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.exception.InvalidInputException;
import com.example.studentapi.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Map<Long, Student> studentDB = new HashMap<>();

    static {
        studentDB.put(1L, new Student(1L, "Rahul", "CSE"));
        studentDB.put(2L, new Student(2L, "Anita", "ECE"));
        studentDB.put(3L, new Student(3L, "Kiran", "IT"));
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        Long studentId;

        try {
            studentId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        Student student = studentDB.get(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return student;
    }
}
