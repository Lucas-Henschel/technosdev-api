package com.technosdev.resources;

import com.technosdev.entities.Address;
import com.technosdev.entities.Company;
import com.technosdev.entities.Employee;
import com.technosdev.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@Valid @PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@Valid @RequestBody Employee employee){

        employee.setActive(true);
        employee = employeeService.insert(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(uri).body(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(@Valid @PathVariable Long id, @Valid @RequestBody Employee employee) {
        employee = employeeService.update(id, employee);
        return ResponseEntity.ok().body(employee);
    }

}
