package com.technosdev.services;

import com.technosdev.entities.Address;
import com.technosdev.entities.Company;
import com.technosdev.repositories.CompanyRepository;
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
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        Optional<Company> address = companyRepository.findById(id);
        return address.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Company insert(Company company){
        return companyRepository.save(company);
    }

    public void delete(Long id){
        try {
            findById(id);
            companyRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Company update(Long id, Company company , Address address) {
        try {
            Company entity = companyRepository.getReferenceById(id);
            updateData(entity, company , address);
            return companyRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Company entity, Company company , Address address) {
        entity.setAddress(address);
        entity.setName(company.getName());
        entity.setCnpj(company.getCnpj());
        entity.setEmail(company.getEmail());
        entity.setPhone(company.getPhone());
        entity.setUser(company.getUser());
        entity.setPassword(company.getPassword());
        entity.setActive(company.getActive());
    }

}
