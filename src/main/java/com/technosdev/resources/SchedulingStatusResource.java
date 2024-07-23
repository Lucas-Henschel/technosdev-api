package com.technosdev.resources;

import com.technosdev.entities.SchedulingStatus;
import com.technosdev.services.SchedulingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
