package com.technosdev.services;

import com.technosdev.entities.Client;
import com.technosdev.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return client.get();
    }

    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client update(Long id, Client client) {
        Client entity = clientRepository.getReferenceById(id);
        updateData(entity, client);
        return clientRepository.save(entity);
    }

    private void updateData(Client entity, Client client) {
        entity.setNmClient(client.getNmClient());
        entity.setNmrPhone(client.getNmrPhone());
        entity.setActive(client.isActive());
        entity.setNmrCpf(client.getNmrCpf());
    }
}
