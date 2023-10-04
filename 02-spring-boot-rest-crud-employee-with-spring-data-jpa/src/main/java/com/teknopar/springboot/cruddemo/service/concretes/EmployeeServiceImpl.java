package com.teknopar.springboot.cruddemo.service.concretes;

import com.teknopar.springboot.cruddemo.model.Employee;
import com.teknopar.springboot.cruddemo.repository.EmployeeRepository;
import com.teknopar.springboot.cruddemo.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        /*
        Optional<Employee> result = this.employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        }
        else{
        throw new RunTimeException("Did not find employee id - " + id);
        }
        return employee;
        */
        /*
        Employee employee = this.employeeRepository.findById(id).get();
        return employee;
        */
        return this.employeeRepository.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}
