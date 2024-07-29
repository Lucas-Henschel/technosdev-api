package com.technosdev.resources;

import com.technosdev.entities.City;
import com.technosdev.services.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/county")
public class CountyResource {
    @Autowired
    private CountyService countyService;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        List<City> counties = countyService.findAll();
        return ResponseEntity.ok().body(counties);
    }

}
