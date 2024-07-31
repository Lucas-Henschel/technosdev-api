package com.technosdev.services;

import com.technosdev.entities.EmployeeService;
import com.technosdev.repositories.EmployeeServiceRepository;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceService {
    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    public List<EmployeeService> findAll() {
        return employeeServiceRepository.findAll();
    }

    public EmployeeService findById(Long id) {
        Optional<EmployeeService> employee = employeeServiceRepository.findById(id);
        return employee.orElseThrow(() -> new ResourceNotFoundException("Serviço do colaborador não encontrado"));
    }

}
