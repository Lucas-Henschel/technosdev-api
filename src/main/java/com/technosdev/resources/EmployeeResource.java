package com.technosdev.resources;

import com.technosdev.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

}
