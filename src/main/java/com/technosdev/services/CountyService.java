package com.technosdev.services;

import com.technosdev.repositories.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountyService {
    @Autowired
    private CountyRepository countyRepository;

}
