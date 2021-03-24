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
@CrossOrigin(origins = {"http://localhost: 8082","http://localhost:4200"})
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    Employee employee1 = new Employee(1, "Joep","Janssen", "", Gender.Male, new Date(), null, null, 1);
    Employee employee2 = new Employee(2, "Dirk","Wiel", "van der", Gender.Male, new Date(), null, null, 1);

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> all() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
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
