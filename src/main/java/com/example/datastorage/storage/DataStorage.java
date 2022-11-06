package com.example.datastorage.storage;

import com.example.datastorage.entity.Student;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;

@Repository
public class DataStorage {
    private final LinkedList<Student> data = new LinkedList<>();

    public Student saveStudent(Student st) {
        Student.builder().
                id(st.getId()).
                name(st.getName()).
                surname(st.getSurname()).
                age(st.getAge());
        data.add(st);
        return st;
    }

    public LinkedList<Student> getAllStudents(){
        return data;
    }

    public Student getByID(long id){
        for (Student st : data) {
            if (st.getId() == id ){
                return st;
            }
        }
        return null;
    }

    public void delete(long id){
        data.removeIf(st -> st.getId() == id);
    }

    public Student update(Student student){
        Student newStudent = new Student();
        if (data.contains(student)){
            newStudent.setId(student.getId());
            newStudent.setName(student.getName());
            newStudent.setSurname(student.getSurname());
            newStudent.setAge(student.getAge());
            data.set(data.indexOf(student), student);
        }
        return newStudent;
    }
}
