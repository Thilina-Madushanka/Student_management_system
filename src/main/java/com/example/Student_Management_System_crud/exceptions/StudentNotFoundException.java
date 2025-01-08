package com.example.Student_Management_System_crud.exceptions;

public class StudentNotFoundException extends RuntimeException { //going to import global exception class
    public StudentNotFoundException(String message) {
        super(message);
    }
}
