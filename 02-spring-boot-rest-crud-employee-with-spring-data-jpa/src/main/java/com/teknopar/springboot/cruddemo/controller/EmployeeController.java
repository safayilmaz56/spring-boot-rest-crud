package com.teknopar.springboot.cruddemo.controller;

import com.teknopar.springboot.cruddemo.model.Employee;
import com.teknopar.springboot.cruddemo.service.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = this.employeeService.findById(id);

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee employee1 = this.employeeService.save(employee);
        return employee1;
    }

    @PutMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable int id){
        Employee employee = this.employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee id not found - " + id);
        this.employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }
}
