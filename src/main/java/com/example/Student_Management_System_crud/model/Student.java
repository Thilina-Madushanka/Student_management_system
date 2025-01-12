package com.example.Student_Management_System_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;


@Entity
//@Setter  // Lombok will generate getters, setters, toString, equals, and hashCode
//@Getter
@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor  // Generates a no-args constructor

public class Student {
    @Id //make id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //make id auto generate
    private Integer id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true) //same email does not exists
    private String email;
    private String department;

    public String getFormattedId() {
        return id != null ? String.format("%03d", id) : null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }



}
