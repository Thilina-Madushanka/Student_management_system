package com.example.Student_Management_System_crud.service;

import com.example.Student_Management_System_crud.model.Student;

import java.util.List;

public interface IStudentService {

    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Integer id);
    Student getStudentById(Integer id);
    void deleteStudent(Integer id);
}
