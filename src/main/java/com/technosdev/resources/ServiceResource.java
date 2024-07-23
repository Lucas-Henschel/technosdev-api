package com.technosdev.resources;

import com.technosdev.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service")
public class ServiceResource {
    @Autowired
    private ServiceService serviceService;

}
