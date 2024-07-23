package com.technosdev.services;

import com.technosdev.entities.ServiceOrder;
import com.technosdev.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<ServiceOrder> findAll() {
        return serviceOrderRepository.findAll();
    }
}
