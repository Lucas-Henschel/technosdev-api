package com.technosdev.services;

import com.technosdev.repositories.ServiceRepository;
import com.technosdev.services.exceptions.DatabaseException;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.technosdev.entities.Service> findAll() {
        return serviceRepository.findAll();
    }

    public com.technosdev.entities.Service findById(Long id) {
        Optional<com.technosdev.entities.Service> client = serviceRepository.findById(id);
        return client.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public com.technosdev.entities.Service insert(com.technosdev.entities.Service service) {
        service.setActive(true);
        return serviceRepository.save(service);
    }

    public void delete(Long id) {
        try {
            findById(id);
            serviceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public com.technosdev.entities.Service update(Long id, com.technosdev.entities.Service service) {
        try {
            com.technosdev.entities.Service entity = serviceRepository.getReferenceById(id);
            updateData(entity, service);
            return serviceRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }

    private void updateData(com.technosdev.entities.Service entity, com.technosdev.entities.Service client) {
        entity.setCompany(client.getCompany());
        entity.setName(client.getName());
        entity.setDescription(client.getDescription());
        entity.setPrice(client.getPrice());
        entity.setAverageTime(client.getAverageTime());
    }

}
