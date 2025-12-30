package com.aws.course.route53.controller;

import com.aws.course.route53.service.Route53Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.route53.model.HostedZone;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/route53")
public class Route53Controller {

    private final Route53Service route53Service;

    @Autowired
    public Route53Controller(Route53Service route53Service) {
        this.route53Service = route53Service;
    }

    @PostMapping("/zones")
    public String createHostedZone(@RequestParam String domainName) {
        return route53Service.createHostedZone(domainName);
    }

    @GetMapping("/zones")
    public List<HostedZone> listHostedZones() {
        return route53Service.listHostedZones();
    }

    @PostMapping("/zones/{zoneId}/records")
    public String createDnsRecord(@PathVariable String zoneId, @RequestParam String recordName,
            @RequestParam String recordValue, @RequestParam String type) {
        return route53Service.createDnsRecord(zoneId, recordName, recordValue, type);
    }
}
