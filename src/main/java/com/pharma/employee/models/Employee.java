package com.pharma.employee.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "MiddleName")
    private String middleName;
    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
}

