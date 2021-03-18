package com.pharma.employee.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "_Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    public Role(){

    }

}
