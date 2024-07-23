package com.technosdev.resources;

import com.technosdev.services.SchedulingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/schedulingStatus")
public class SchedulingStatusResource {
    @Autowired
    private SchedulingStatusService schedulingStatusService;

}
