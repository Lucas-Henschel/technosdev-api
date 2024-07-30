package com.technosdev.services;

import com.technosdev.entities.Employee;
import com.technosdev.repositories.EmployeeRepository;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Employee insert(Employee employee){
        return employeeRepository.save(employee);
    }

}
