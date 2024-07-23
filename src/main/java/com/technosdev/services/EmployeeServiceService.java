package com.technosdev.services;

import com.technosdev.repositories.EmployeeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceService {
    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

}
