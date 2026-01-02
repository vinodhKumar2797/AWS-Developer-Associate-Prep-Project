package com.aws.course.route53.config;

import com.aws.course.common.config.LoggingConfig;
import com.aws.course.common.interceptor.AwsLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.services.route53.Route53Client;

@Configuration
@Import(LoggingConfig.class)
public class Route53Config {

    @Bean
    public Route53Client route53Client() {
        return Route53Client.builder()
                .overrideConfiguration(c -> c.addExecutionInterceptor(new AwsLoggingInterceptor())).build();
    }
}
