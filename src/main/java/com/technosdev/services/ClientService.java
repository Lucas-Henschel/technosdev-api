package com.technosdev.services;

import com.technosdev.entities.Client;
import com.technosdev.repositories.ClientRepository;
import com.technosdev.services.exceptions.DatabaseException;
import com.technosdev.services.exceptions.ResourceAlreadyExistsException;
import com.technosdev.services.exceptions.ResourceNotFoundException;
import com.technosdev.services.exceptions.UnprocessableEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public Client insert(Client client) {

        if (clientRepository.findByCpf(client.getCpf()).isPresent()){
            throw new UnprocessableEntityException("Cpf não é válido");
        }

        client.setActive(true);
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        try {
            findById(id);
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Client update(Long id, Client client) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            updateData(entity, client);
            return clientRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
    }

    private void updateData(Client entity, Client client) {
        entity.setName(client.getName());
        entity.setName(client.getName());
        entity.setActive(client.isActive());
        entity.setCpf(client.getCpf());
    }
}
