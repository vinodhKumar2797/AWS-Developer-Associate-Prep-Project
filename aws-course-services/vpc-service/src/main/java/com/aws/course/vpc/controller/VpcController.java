package com.aws.course.vpc.controller;

import com.aws.course.vpc.service.VpcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.ec2.model.Vpc;

import java.util.List;

@RestController
@RequestMapping("/api/vpcs")
public class VpcController {

    private final VpcService vpcService;

    public VpcController(VpcService vpcService) {
        this.vpcService = vpcService;
    }

    @GetMapping
    public List<Vpc> getVpcs() {
        return vpcService.getAllVpcs();
    }
}
