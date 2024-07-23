package com.technosdev.resources;

import com.technosdev.entities.Address;
import com.technosdev.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
