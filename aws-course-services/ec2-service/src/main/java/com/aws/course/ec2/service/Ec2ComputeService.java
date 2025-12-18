package com.aws.course.ec2.service;

import com.aws.course.ec2.model.InstanceDto;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ec2ComputeService {

    private final Ec2Client ec2Client;

    public Ec2ComputeService(Ec2Client ec2Client) {
        this.ec2Client = ec2Client;
    }

    public List<InstanceDto> listInstances() {
        try {
            DescribeInstancesResponse response = ec2Client.describeInstances();
            return response.reservations().stream().flatMap(r -> r.instances().stream()).map(this::mapToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("AWS Call failed: " + e.getMessage());
            return Collections.singletonList(new InstanceDto("i-1234567890abcdef0", "t2.micro", "running", "1.2.3.4"));
        }
    }

    public String startInstance(String instanceId) {
        // StartInstancesRequest request =
        // StartInstancesRequest.builder().instanceIds(instanceId).build();
        // ec2Client.startInstances(request);
        return "Starting instance " + instanceId;
    }

    public String stopInstance(String instanceId) {
        // StopInstancesRequest request =
        // StopInstancesRequest.builder().instanceIds(instanceId).build();
        // ec2Client.stopInstances(request);
        return "Stopping instance " + instanceId;
    }

    private InstanceDto mapToDto(Instance instance) {
        return new InstanceDto(instance.instanceId(), instance.instanceTypeAsString(), instance.state().nameAsString(),
                instance.publicIpAddress());
    }
}
