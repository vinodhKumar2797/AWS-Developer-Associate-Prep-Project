package com.cloud.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.GetCallerIdentityResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/aws")
public class AwsIdentityController {

    private final StsClient stsClient;

    public AwsIdentityController(StsClient stsClient) {
        this.stsClient = stsClient;
    }

    @GetMapping("/whoami")
    public Map<String, String> whoAmI() {
        GetCallerIdentityResponse identity = stsClient.getCallerIdentity();
        Map<String, String> response = new HashMap<>();
        response.put("UserId", identity.userId());
        response.put("Account", identity.account());
        response.put("Arn", identity.arn());
        return response;
    }
}
