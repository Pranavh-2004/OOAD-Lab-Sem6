package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ==================== WEB ENDPOINTS (for browser) ====================

    // Show home page with form and student list
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    // Add new student (from web form)
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        try {
            studentService.addStudent(student);
            redirectAttributes.addFlashAttribute("success", "Student added successfully!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    // ==================== REST API ENDPOINTS ====================

    // POST /api/students - Create new student
    @PostMapping("/api/students")
    @ResponseBody
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try {
            Student saved = studentService.addStudent(student);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /api/students - Get all students
    @GetMapping("/api/students")
    @ResponseBody
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
}
