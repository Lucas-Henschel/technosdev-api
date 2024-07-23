package com.technosdev.services;

import com.technosdev.entities.EmployeeService;
import com.technosdev.repositories.EmployeeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceService {
    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    public List<EmployeeService> findAll() {
        return employeeServiceRepository.findAll();
    }
}
