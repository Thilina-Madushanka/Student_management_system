package com.example.Student_Management_System_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id //make id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //make id auto generate
    private int id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true) //same email does not exists
    private String email;
    private String department;


}
