package com.technosdev.resources;

import com.technosdev.entities.EmployeeService;
import com.technosdev.services.EmployeeServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employeeService")
public class EmployeeServiceResource {
    @Autowired
    private EmployeeServiceService employeeServiceService;

    @GetMapping
    public ResponseEntity<List<EmployeeService>> findAll() {
        List<EmployeeService> employeeServices = employeeServiceService.findAll();
        return ResponseEntity.ok().body(employeeServices);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<EmployeeService> getById(@PathVariable Long id){
        EmployeeService employeeServices = employeeServiceService.findById(id);
        return ResponseEntity.ok().body(employeeServices);
    }

    @PostMapping
    public ResponseEntity<EmployeeService> insert(@Valid @RequestBody EmployeeService employeeService){
        employeeService = employeeServiceService.insert(employeeService);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employeeService.getId()).toUri();

        return ResponseEntity.created(uri).body(employeeService);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeService> update(@Valid @PathVariable Long id, @Valid @RequestBody EmployeeService employeeService) {
        employeeService = employeeServiceService.update(id, employeeService);
        return ResponseEntity.ok().body(employeeService);
    }

}
