package com.aws.course.ec2.config;

import com.aws.course.common.config.LoggingConfig;
import com.aws.course.common.interceptor.AwsLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;

@Configuration
@Import(LoggingConfig.class)
public class Ec2Config {

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.AWS_GLOBAL).credentialsProvider(ProfileCredentialsProvider.create())
                .overrideConfiguration(c -> c.addExecutionInterceptor(new AwsLoggingInterceptor())).build();
    }
}
