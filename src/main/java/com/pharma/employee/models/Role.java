package com.pharma.employee.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;

}
