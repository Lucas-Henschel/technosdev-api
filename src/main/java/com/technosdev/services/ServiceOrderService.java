package com.technosdev.services;

import com.technosdev.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

}
