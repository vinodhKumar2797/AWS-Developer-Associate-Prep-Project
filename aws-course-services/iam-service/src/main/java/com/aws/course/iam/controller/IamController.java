package com.aws.course.iam.controller;

import com.aws.course.iam.model.UserDto;
import com.aws.course.iam.service.IamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iam")
public class IamController {

    private final IamService iamService;

    public IamController(IamService iamService) {
        this.iamService = iamService;
    }

    @GetMapping("/users")
    public List<UserDto> listUsers() {
        return iamService.listUsers();
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestParam String userName) {
        return iamService.createUser(userName);
    }
}
