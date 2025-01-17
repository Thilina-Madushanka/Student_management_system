package com.example.Student_Management_System_crud.controller;

import com.example.Student_Management_System_crud.model.Student;
import com.example.Student_Management_System_crud.service.IStudentService;
import com.example.Student_Management_System_crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
//@RequiredArgsConstructor-to inject we use lombok -> need to use final keyword to class
public class StudentController {
//    private final IStudentService studentService; //inject through the constructor -> need to use final
@Autowired
private StudentService studentService;
//@RequiredArgsConstructor
//private final IStudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id){
        return studentService.updateStudent(student, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
}
