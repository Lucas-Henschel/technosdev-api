package com.technosdev.services;

import com.technosdev.entities.Client;
import com.technosdev.entities.Employee;
import com.technosdev.entities.EmployeeService;
import com.technosdev.repositories.EmployeeServiceRepository;
import com.technosdev.services.exceptions.DatabaseException;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import com.technosdev.services.exceptions.UnprocessableEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public EmployeeService insert(EmployeeService employeeService) {
        return employeeServiceRepository.save(employeeService);
    }

    public void delete(Long id) {
        try {
            findById(id);
            employeeServiceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Serviço do colaborador não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public EmployeeService update(Long id, EmployeeService employeeService) {
        try {
            EmployeeService entity = employeeServiceRepository.getReferenceById(id);
            updateData(entity, employeeService);
            return employeeServiceRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Empresa não encontrada");
        }
    }

    private void updateData(EmployeeService entity, EmployeeService employeeService) {
        entity.setEmployee(employeeService.getEmployee());
        entity.setService(employeeService.getService());
    }

}
