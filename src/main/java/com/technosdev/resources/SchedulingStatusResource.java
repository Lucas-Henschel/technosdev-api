package com.technosdev.resources;

import com.technosdev.entities.Client;
import com.technosdev.entities.SchedulingStatus;
import com.technosdev.services.SchedulingStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/schedulingStatus")
public class SchedulingStatusResource {
    @Autowired
    private SchedulingStatusService schedulingStatusService;

    @GetMapping
    public ResponseEntity<List<SchedulingStatus>> findAll() {
        List<SchedulingStatus> schedulingStatuses = schedulingStatusService.findAll();
        return ResponseEntity.ok().body(schedulingStatuses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SchedulingStatus> getById(@PathVariable Long id){
        SchedulingStatus schedulingStatus = schedulingStatusService.findById(id);
        return ResponseEntity.ok().body(schedulingStatus);
    }

    @PostMapping
    public ResponseEntity<SchedulingStatus> insert(@Valid @RequestBody SchedulingStatus schedulingStatus){
        schedulingStatus = schedulingStatusService.insert(schedulingStatus);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(schedulingStatus.getId()).toUri();

        return ResponseEntity.created(uri).body(schedulingStatus);
    }

}
