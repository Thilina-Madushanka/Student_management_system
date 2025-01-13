package com.example.Student_Management_System_crud.service;

import com.example.Student_Management_System_crud.exceptions.StudentAlreadyExistsException;
import com.example.Student_Management_System_crud.exceptions.StudentNotFoundException;
import com.example.Student_Management_System_crud.model.Student;
import com.example.Student_Management_System_crud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //need to specify to service class
//@RequiredArgsConstructor //inject dependencies to


public class StudentService implements IStudentService{ //use code to @RequiredArgsConstructor
//    private final StudentRepository studentRepository; //get students from repository -> use @RequiredArgsConstructor
// constructor inject
@Autowired
    private StudentRepository studentRepository;
//    public StudentService(StudentRepository studentRepository) { //manually initialize repository
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //add student
    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getEmail()+ "student already exists");
        }
        return studentRepository.save(student);
    }
    //update students
    @Override
    public Student updateStudent(Student student, Integer id) {
        return studentRepository.findById(id).map(st ->{
          st.setFirstName(student.getFirstName());
          st.setLastName(student.getLastName());
          st.setEmail(student.getEmail());
          st.setDepartment(student.getDepartment());
          return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("sorry this student not found"));
    }

    //get student by id
    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("sorry student not found within this id! :" + id));
    }
    //delete student
    @Override
    public void deleteStudent(Integer id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("sorry, this student not found");
        }
        studentRepository.deleteById(id);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

}
