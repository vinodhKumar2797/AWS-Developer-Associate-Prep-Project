package com.aws.course.iam.config;

import com.aws.course.common.config.LoggingConfig;
import com.aws.course.common.interceptor.AwsLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;

@Configuration
@Import(LoggingConfig.class)
public class IamConfig {

    @Bean
    public IamClient iamClient() {
        // In a real scenario, you'd configure region and credentials more dynamically.
        // For now, using default profile and standard region.
        return IamClient.builder().region(Region.AWS_GLOBAL).credentialsProvider(ProfileCredentialsProvider.create())
                .overrideConfiguration(c -> c.addExecutionInterceptor(new AwsLoggingInterceptor())).build();
    }
}
