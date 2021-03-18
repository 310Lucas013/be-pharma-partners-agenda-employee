package com.pharma.employee.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @OneToMany(mappedBy = "employee")
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "employee")
    private List<Role> roles;
    @Column(name = "location_id")
    private long locationId;

    public Employee(){

    }
}

