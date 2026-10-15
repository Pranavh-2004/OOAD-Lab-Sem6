package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Boot automatically gives you: save(), findAll(), findById(), deleteById()
    
    // Check if email already exists
    boolean existsByEmail(String email);
    
    // Find students by course
    List<Student> findByCourse(String course);
}
