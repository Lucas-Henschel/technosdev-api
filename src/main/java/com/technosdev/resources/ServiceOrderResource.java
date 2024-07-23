package com.technosdev.resources;

import com.technosdev.entities.ServiceOrder;
import com.technosdev.services.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/serviceOrder")
public class ServiceOrderResource {
    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public ResponseEntity<List<ServiceOrder>> findAll() {
        List<ServiceOrder> serviceOrders = serviceOrderService.findAll();
        return ResponseEntity.ok().body(serviceOrders);
    }
}
