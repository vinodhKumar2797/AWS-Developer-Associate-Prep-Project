package com.aws.course.vpc.config;

import com.aws.course.common.config.LoggingConfig;
import com.aws.course.common.interceptor.AwsLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;

@Configuration
@Import(LoggingConfig.class)
public class VpcConfig {

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.US_EAST_1)
                .overrideConfiguration(c -> c.addExecutionInterceptor(new AwsLoggingInterceptor())).build();
    }
}
