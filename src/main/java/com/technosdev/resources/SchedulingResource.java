package com.technosdev.resources;

import com.technosdev.entities.Scheduling;
import com.technosdev.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingResource {
    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    public ResponseEntity<List<Scheduling>> findAll() {
        List<Scheduling> schedulings = schedulingService.findAll();
        return ResponseEntity.ok().body(schedulings);
    }

}
