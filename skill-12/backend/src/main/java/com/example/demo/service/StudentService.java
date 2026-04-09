package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
 private List<Student> students = new ArrayList<>();
 private Long idCounter = 1L;

 public List<Student> getAll() { return students; }

 public Student add(Student s) {
  s.setId(idCounter++);
  students.add(s);
  return s;
 }

 public void delete(Long id) {
  students.removeIf(s -> s.getId().equals(id));
 }
}