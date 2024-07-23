package com.technosdev.resources;

import com.technosdev.entities.EmployeeService;
import com.technosdev.services.EmployeeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
