package com.technosdev.resources;

import com.technosdev.entities.Address;
import com.technosdev.entities.Client;
import com.technosdev.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> addresses = addressService.findAll();
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Address> insert(@RequestBody Address address){
        address = addressService.insert(address);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(uri).body(address);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address address) {
        address = addressService.update(id, address);
        return ResponseEntity.ok().body(address);
    }

}
