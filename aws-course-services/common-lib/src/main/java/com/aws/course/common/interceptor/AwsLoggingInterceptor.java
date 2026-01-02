package com.aws.course.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;

public class AwsLoggingInterceptor implements ExecutionInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AwsLoggingInterceptor.class);

    @Override
    public void beforeExecution(Context.BeforeExecution context, ExecutionAttributes executionAttributes) {
        logger.info("Sending AWS Request: {}", context.request().getClass().getSimpleName());
    }

    @Override
    public void afterExecution(Context.AfterExecution context, ExecutionAttributes executionAttributes) {
        logger.info("Received AWS Response: {}", context.response().getClass().getSimpleName());
    }

    @Override
    public void onExecutionFailure(Context.FailedExecution context, ExecutionAttributes executionAttributes) {
        logger.error("AWS Request Failed", context.exception());
    }
}
