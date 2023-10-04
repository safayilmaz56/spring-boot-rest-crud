package com.teknopar.springboot.cruddemo.repository;

import com.teknopar.springboot.cruddemo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = this.entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = this.entityManager.merge(employee);
        return employee1;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = this.entityManager.find(Employee.class,id);
        this.entityManager.remove(employee);
    }
}
