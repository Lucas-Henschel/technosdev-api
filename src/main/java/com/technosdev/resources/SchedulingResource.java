package com.technosdev.resources;

import com.technosdev.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingResource {
    @Autowired
    private SchedulingService schedulingService;

}
