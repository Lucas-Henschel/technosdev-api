package com.technosdev.services;

import com.technosdev.entities.SchedulingStatus;
import com.technosdev.repositories.SchedulingStatusRepository;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingStatusService {
    @Autowired
    private SchedulingStatusRepository schedulingStatusRepository;

    public List<SchedulingStatus> findAll() {
        return schedulingStatusRepository.findAll();
    }

    public SchedulingStatus findById(Long id){
        Optional<SchedulingStatus> schedulingStatus = schedulingStatusRepository.findById(id);
        return schedulingStatus.orElseThrow(() -> new ResourceNotFoundException("Status não encontrado"));
    }

    public SchedulingStatus insert(SchedulingStatus schedulingStatus){
        schedulingStatus.setActive(true);
        return schedulingStatusRepository.save(schedulingStatus);
    }

}
