package com.aws.course.ec2.controller;

import com.aws.course.ec2.model.InstanceDto;
import com.aws.course.ec2.service.Ec2ComputeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ec2")
public class InstanceController {

    private final Ec2ComputeService ec2Service;

    public InstanceController(Ec2ComputeService ec2Service) {
        this.ec2Service = ec2Service;
    }

    @GetMapping("/instances")
    public List<InstanceDto> listInstances() {
        return ec2Service.listInstances();
    }

    @PostMapping("/instances/{id}/start")
    public String startInstance(@PathVariable String id) {
        return ec2Service.startInstance(id);
    }

    @PostMapping("/instances/{id}/stop")
    public String stopInstance(@PathVariable String id) {
        return ec2Service.stopInstance(id);
    }
}
