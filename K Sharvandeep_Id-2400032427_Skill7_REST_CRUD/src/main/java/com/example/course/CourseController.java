
package com.example.course;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        service.addCourse(course);
        return new ResponseEntity<>("Course added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course){
        Course updated = service.updateCourse(id, course);
        if(updated == null){
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        boolean deleted = service.deleteCourse(id);
        if(!deleted){
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title){
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}
