package com.cloud.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Instance;
import software.amazon.awssdk.services.ec2.model.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aws")
public class Ec2Controller {

    private final Ec2Client ec2Client;

    public Ec2Controller(Ec2Client ec2Client) {
        this.ec2Client = ec2Client;
    }

    @GetMapping("/instances")
    public List<Map<String, String>> listInstances() {
        DescribeInstancesResponse response = ec2Client.describeInstances();
        List<Map<String, String>> instanceDetails = new ArrayList<>();

        for (Reservation reservation : response.reservations()) {
            for (Instance instance : reservation.instances()) {
                Map<String, String> details = new HashMap<>();
                details.put("InstanceId", instance.instanceId());
                details.put("InstanceType", instance.instanceTypeAsString());
                details.put("State", instance.state().nameAsString());
                details.put("PublicIp", instance.publicIpAddress());
                details.put("PrivateIp", instance.privateIpAddress());
                instanceDetails.add(details);
            }
        }
        return instanceDetails;
    }
}
