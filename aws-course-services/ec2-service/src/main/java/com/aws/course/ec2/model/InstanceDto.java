package com.aws.course.ec2.model;

public class InstanceDto {
    private String instanceId;
    private String instanceType;
    private String state;
    private String publicIp;

    public InstanceDto(String instanceId, String instanceType, String state, String publicIp) {
        this.instanceId = instanceId;
        this.instanceType = instanceType;
        this.state = state;
        this.publicIp = publicIp;
    }

    // Getters and Setters
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }
}
