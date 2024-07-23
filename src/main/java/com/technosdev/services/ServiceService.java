package com.technosdev.services;

import com.technosdev.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.technosdev.entities.Service> findAll() {
        return serviceRepository.findAll();
    }
}
