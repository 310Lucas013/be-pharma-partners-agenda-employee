package com.pharma.employee.controllers;

import com.pharma.employee.models.Employee;
import com.pharma.employee.models.Gender;
import com.pharma.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> all() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> add(Employee employee) {
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        employeeService.delete(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> put(@RequestBody Employee newEmployee, @PathVariable long id) {
        employeeService.findbyId(id)
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setMiddleName(newEmployee.getMiddleName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setGender(newEmployee.getGender());
                    employee.setDateOfBirth(newEmployee.getDateOfBirth());
                    return new ResponseEntity<>(employeeService.add(employee), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return new ResponseEntity<>(employeeService.add(newEmployee), HttpStatus.OK);
                });
        return new ResponseEntity<>(employeeService.add(newEmployee), HttpStatus.BAD_GATEWAY);
    }

}
