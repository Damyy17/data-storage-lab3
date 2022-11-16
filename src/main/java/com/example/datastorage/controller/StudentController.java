package com.example.datastorage.controller;

import com.example.datastorage.entity.Student;
import com.example.datastorage.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/university/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id){
        if (studentService.getStudentById(id) == null){
            throw new RuntimeException("Student with id" + id + " does not exist!");
        } else
            return studentService.getStudentById(id);
    }

    @GetMapping
    public LinkedList<Student> getAllStudent(){
        return studentService.getStudents();
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

}
