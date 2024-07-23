package com.technosdev.services;

import com.technosdev.entities.SchedulingStatus;
import com.technosdev.repositories.SchedulingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingStatusService {
    @Autowired
    private SchedulingStatusRepository schedulingStatusRepository;

    public List<SchedulingStatus> findAll() {
        return schedulingStatusRepository.findAll();
    }

}
