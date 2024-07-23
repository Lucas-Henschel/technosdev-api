package com.technosdev.services;

import com.technosdev.repositories.SchedulingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingStatusService {
    @Autowired
    private SchedulingStatusRepository schedulingStatusRepository;

}
