package com.users_api.controller;

import com.users_api.dto.UserDto;
import com.users_api.entity.User;
import com.users_api.mapper.UserMapper;
import com.users_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = users.stream().map(userMapper::mapToDto).toList();
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @GetMapping("/create-all")
    public ResponseEntity<String> createUsers() {
        userService.createUsers();
        return new ResponseEntity<>("Users has been created successfully", HttpStatus.OK);
    }




}
