package com.users_api.controller;

import com.users_api.dto.UserDto;
import com.users_api.entity.User;
import com.users_api.mapper.UserMapper;
import com.users_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDto userDto = userMapper.mapToDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToEntity(userDto);
        User createdUser = userService.createUser(user);
        UserDto createdUserDto = userMapper.mapToDto(createdUser);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

}
