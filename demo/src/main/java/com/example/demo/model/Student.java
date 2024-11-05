package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"email id"})}, name = "Student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first name", nullable = false)
    private String firstName;
    @Column(name = "last name", nullable = false)
    private String lastName;
    @Column(name = "email id",nullable = false)
    private String email;
    @Column(name = "Department", nullable = false)
    private String department;
    @Column(name = "yearOfEnrollment", nullable = false)
    private String yearOfEnrollment;

}
