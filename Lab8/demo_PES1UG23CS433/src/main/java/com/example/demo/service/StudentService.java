package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Create - Add new student (prevents duplicate email)
    public Student addStudent(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        return repository.save(student);
    }

    // Read - Get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Read - Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    // Read - Get students by course
    public List<Student> getStudentsByCourse(String course) {
        return repository.findByCourse(course);
    }

    // Delete student
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
