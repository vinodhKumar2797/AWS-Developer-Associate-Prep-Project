package com.aws.course.iam.model;

public class UserDto {
    private String userName;
    private String userId;
    private String arn;
    private String createDate;

    public UserDto(String userName, String userId, String arn, String createDate) {
        this.userName = userName;
        this.userId = userId;
        this.arn = arn;
        this.createDate = createDate;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
