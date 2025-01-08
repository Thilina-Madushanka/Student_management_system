package com.example.Student_Management_System_crud.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String message) { //going to import global exception class
    super(message);
    }
}
