package com.technosdev.services;

import com.technosdev.entities.Address;
import com.technosdev.entities.Client;
import com.technosdev.repositories.AddressRepository;
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
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address insert(Address address){
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        try {
            findById(id);
            addressRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Address update(Long id, Address address) {
        try {
            Address entity = addressRepository.getReferenceById(id);
            updateData(entity, address);
            return addressRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Address entity, Address address) {
        entity.setCity(address.getCity());
        entity.setPublicPlace(address.getPublicPlace());
        entity.setLocality(address.getLocality());
        entity.setCep(address.getCep());
        entity.setComplement(address.getComplement());
    }

}
