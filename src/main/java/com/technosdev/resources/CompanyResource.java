package com.technosdev.resources;

import com.technosdev.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company")
public class CompanyResource {
    @Autowired
    private CompanyService companyService;

}
