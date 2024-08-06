package com.technosdev.services;

import com.technosdev.entities.Scheduling;
import com.technosdev.repositories.SchedulingRepository;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulingService {
    @Autowired
    private SchedulingRepository schedulingRepository;

    public List<Scheduling> findAll() {
        return schedulingRepository.findAll();
    }

    public Scheduling findById(Long id) {
        Optional<Scheduling> employee = schedulingRepository.findById(id);
        return employee.orElseThrow(() -> new ResourceNotFoundException("Agendamento do colaborador não encontrado"));
    }

    public Scheduling insert(Scheduling scheduling){
        return schedulingRepository.save(scheduling);
    }

}
