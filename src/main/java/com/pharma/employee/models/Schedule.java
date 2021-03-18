package com.pharma.employee.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "StartDate")
    private Date startDate;
    @Column(name = "EndDate")
    private Date endDate;
    @OneToMany(mappedBy = "schedule")
    private List<Availability> availabilities;
    @ManyToOne()
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    public Schedule() {

    }
}
