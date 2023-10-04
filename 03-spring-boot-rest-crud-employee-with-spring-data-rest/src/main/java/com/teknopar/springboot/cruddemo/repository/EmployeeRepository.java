package com.teknopar.springboot.cruddemo.repository;

import com.teknopar.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findById(int id);
}
