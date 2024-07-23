package com.technosdev.services;

import com.technosdev.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

}
