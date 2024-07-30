package com.technosdev.resources;

import com.technosdev.entities.Address;
import com.technosdev.entities.Company;
import com.technosdev.services.AddressService;
import com.technosdev.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyResource {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companies = companyService.findAll();
        return ResponseEntity.ok().body(companies);
    }

    @PostMapping
    public ResponseEntity<Company> insert(@RequestBody Company company){
        company.setActive(true);
        company = companyService.insert(company);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(company.getId()).toUri();

        return ResponseEntity.created(uri).body(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        Address address = addressService.update(company.getAddress().getId() , company.getAddress());
        company = companyService.update(id, company , address);
        return ResponseEntity.ok().body(company);
    }

}
