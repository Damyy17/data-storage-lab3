package com.example.datastorage.service;

import com.example.datastorage.entity.Student;

import java.util.LinkedList;

public interface StudentService {

    Student saveStudent(Student student);

    LinkedList<Student> getStudents();

    Student getStudentById(long id);

    Student updateStudent(long id, Student student);

    String deleteStudent(long id);
}
