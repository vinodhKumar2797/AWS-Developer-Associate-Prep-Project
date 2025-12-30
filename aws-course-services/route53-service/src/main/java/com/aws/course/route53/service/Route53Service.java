package com.aws.course.route53.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.route53.Route53Client;
import software.amazon.awssdk.services.route53.model.*;

import java.util.List;

@Service
public class Route53Service {

    private final Route53Client route53Client;

    @Autowired
    public Route53Service(Route53Client route53Client) {
        this.route53Client = route53Client;
    }

    public String createHostedZone(String domainName) {
        String callerReference = String.valueOf(System.currentTimeMillis());
        CreateHostedZoneRequest request = CreateHostedZoneRequest.builder().name(domainName)
                .callerReference(callerReference).build();

        CreateHostedZoneResponse response = route53Client.createHostedZone(request);
        return response.hostedZone().id();
    }

    public List<HostedZone> listHostedZones() {
        ListHostedZonesResponse response = route53Client.listHostedZones();
        return response.hostedZones();
    }

    public String createDnsRecord(String hostedZoneId, String recordName, String recordValue, String type) {
        ResourceRecord resourceRecord = ResourceRecord.builder().value(recordValue).build();

        ResourceRecordSet resourceRecordSet = ResourceRecordSet.builder().name(recordName)
                .type(RecordType.fromValue(type)).ttl(300L).resourceRecords(resourceRecord).build();

        Change change = Change.builder().action(ChangeAction.CREATE).resourceRecordSet(resourceRecordSet).build();

        ChangeBatch changeBatch = ChangeBatch.builder().changes(change).build();

        ChangeResourceRecordSetsRequest request = ChangeResourceRecordSetsRequest.builder().hostedZoneId(hostedZoneId)
                .changeBatch(changeBatch).build();

        ChangeResourceRecordSetsResponse response = route53Client.changeResourceRecordSets(request);
        return response.changeInfo().id();
    }
}
