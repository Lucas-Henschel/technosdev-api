package com.technosdev.resource;

import com.technosdev.entities.Client;
import com.technosdev.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }
}
