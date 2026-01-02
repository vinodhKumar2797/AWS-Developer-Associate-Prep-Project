package com.aws.course.vpc.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeVpcsResponse;
import software.amazon.awssdk.services.ec2.model.Vpc;

import java.util.List;

@Service
public class VpcService {

    private final Ec2Client ec2Client;

    public VpcService(Ec2Client ec2Client) {
        this.ec2Client = ec2Client;
    }

    public List<Vpc> getAllVpcs() {
        DescribeVpcsResponse response = ec2Client.describeVpcs();
        return response.vpcs();
    }
}
