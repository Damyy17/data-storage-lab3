package com.example.datastorage.service;

import com.example.datastorage.entity.Student;
import com.example.datastorage.storage.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class StudentService {

    @Autowired
    private DataStorage dataStorage;

    public Student saveStudent(Student student){
        return dataStorage.saveStudent(student);
    }

    public LinkedList<Student> getStudents(){
        return dataStorage.getAllStudents();
    }

    public Student getStudentById(long id){
        return dataStorage.getByID(id);
    }

    public Student updateStudent(Student student){
        return dataStorage.update(student);
    }

    public String deleteStudent(long id){
        dataStorage.delete(id);
        return "Student was deleted successfully!";
    }
}
