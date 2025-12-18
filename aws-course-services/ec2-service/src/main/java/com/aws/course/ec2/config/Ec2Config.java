package com.aws.course.ec2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;

@Configuration
public class Ec2Config {

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.AWS_GLOBAL).credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }
}
