package com.technosdev.services;

import com.technosdev.entities.Scheduling;
import com.technosdev.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {
    @Autowired
    private SchedulingRepository schedulingRepository;

    public List<Scheduling> findAll() {
        return schedulingRepository.findAll();
    }
}
