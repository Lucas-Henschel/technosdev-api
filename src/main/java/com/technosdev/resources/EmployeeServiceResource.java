package com.technosdev.resources;

import com.technosdev.services.EmployeeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employeeService")
public class EmployeeServiceResource {
    @Autowired
    private EmployeeServiceService emopEmployeeServiceService;

}
