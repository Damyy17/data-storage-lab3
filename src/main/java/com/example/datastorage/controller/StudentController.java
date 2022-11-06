package com.example.datastorage.controller;

import com.example.datastorage.entity.Student;
import com.example.datastorage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/university/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public LinkedList<Student> getAllStudent(){
        return studentService.getStudents();
    }

    @PutMapping
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

}
