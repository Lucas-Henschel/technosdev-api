package com.technosdev.resources;

import com.technosdev.entities.Company;
import com.technosdev.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyResource {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companies = companyService.findAll();
        return ResponseEntity.ok().body(companies);
    }

}
