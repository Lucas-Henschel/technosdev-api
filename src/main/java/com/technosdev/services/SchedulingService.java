package com.technosdev.services;

import com.technosdev.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {
    @Autowired
    private SchedulingRepository schedulingRepository;

}
