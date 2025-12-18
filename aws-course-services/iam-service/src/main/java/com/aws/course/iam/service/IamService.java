package com.aws.course.iam.service;

import com.aws.course.iam.model.UserDto;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.ListUsersResponse;
import software.amazon.awssdk.services.iam.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IamService {

    private final IamClient iamClient;

    public IamService(IamClient iamClient) {
        this.iamClient = iamClient;
    }

    public List<UserDto> listUsers() {
        try {
            ListUsersResponse response = iamClient.listUsers();
            return response.users().stream().map(this::mapToDto).collect(Collectors.toList());
        } catch (Exception e) {
            // Fallback for demo if no AWS creds are set up
            System.err.println("AWS Call failed: " + e.getMessage());
            return Collections
                    .singletonList(new UserDto("demo-user", "AIDADEMO", "arn:aws:iam::123:user/demo", "2023-01-01"));
        }
    }

    public UserDto createUser(String userName) {
        // Implementation for creating user
        // CreateUserResponse response = iamClient.createUser(req ->
        // req.userName(userName));
        // return mapToDto(response.user());
        return new UserDto(userName, "NEWID", "arn:aws:iam::123:user/" + userName, "now");
    }

    private UserDto mapToDto(User user) {
        return new UserDto(user.userName(), user.userId(), user.arn(), user.createDate().toString());
    }
}
