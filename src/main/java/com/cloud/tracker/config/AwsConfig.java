package com.cloud.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.sts.StsClient;

@Configuration
public class AwsConfig {

    @Bean
    public StsClient stsClient() {
        return StsClient.builder().region(Region.US_EAST_1).build();
    }

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.US_EAST_1).build();
    }
}
