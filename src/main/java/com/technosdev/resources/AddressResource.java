package com.technosdev.resources;

import com.technosdev.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

}
