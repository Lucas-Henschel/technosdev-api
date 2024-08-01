package com.technosdev.resources;

import com.technosdev.entities.Client;
import com.technosdev.entities.Service;
import com.technosdev.services.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceResource {
    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<Service>> findAll() {
        List<Service> services = serviceService.findAll();
        return ResponseEntity.ok().body(services);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Service> findById(@Valid @PathVariable Long id) {
        Service service = serviceService.findById(id);
        return ResponseEntity.ok().body(service);
    }

    @PostMapping
    public ResponseEntity<Service> insert(@Valid @RequestBody Service service) {
        service = serviceService.insert(service);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(service.getId()).toUri();

        return ResponseEntity.created(uri).body(service);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        serviceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Service> update(@Valid @PathVariable Long id, @Valid @RequestBody Service service) {
        service = serviceService.update(id, service);
        return ResponseEntity.ok().body(service);
    }

}
