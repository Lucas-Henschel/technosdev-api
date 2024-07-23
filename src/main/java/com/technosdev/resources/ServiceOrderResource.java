package com.technosdev.resources;

import com.technosdev.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serviceOrder")
public class ServiceOrderResource {
    @Autowired
    private ServiceOrderService serviceOrderService;

}
