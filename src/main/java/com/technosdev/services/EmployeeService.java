package com.technosdev.services;

import com.technosdev.entities.Employee;
import com.technosdev.repositories.EmployeeRepository;
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
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new ResourceNotFoundException("Colaborador não encontrado"));
    }

    public Employee insert(Employee employee){

        if (employeeRepository.findByCpf(employee.getCpf()).isPresent()){
            throw new UnprocessableEntityException("Cpf não é válido");
        }

        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        try {
            findById(id);
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Endereço não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Employee update(Long id, Employee employee) {
        try {
            Employee entity = employeeRepository.getReferenceById(id);
            updateData(entity, employee);
            return employeeRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Empresa não encontrada");
        }
    }

    private void updateData(Employee entity, Employee employee) {
        entity.setName(employee.getName());
        entity.setCpf(employee.getCpf());
        entity.setPhone(employee.getPhone());
        entity.setEmail(employee.getEmail());
        entity.setUser(employee.getUser());
        entity.setPassword(employee.getPassword());
        entity.setActive(employee.getActive());
    }

}
