package com.technosdev.services;

import com.technosdev.entities.County;
import com.technosdev.repositories.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Autowired
    private CountyRepository countyRepository;

    public List<County> findAll() {
        return countyRepository.findAll();
    }
}
