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
        for (Student student : data) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void delete(long id){
        data.removeIf(st -> st.getId() == id);
    }

    public Student update(long id, Student student){
        Student studentById = this.getByID(id);
        if (data.contains(studentById)) {
            Student updatedStudent = data.get(data.indexOf(studentById));
            updatedStudent.setName(student.getName());
            updatedStudent.setSurname(student.getSurname());
            updatedStudent.setAge(student.getAge());
            return updatedStudent;
        } else {
            throw new RuntimeException("Student with id " + student.getId() + " not found");
        }
    }
}
