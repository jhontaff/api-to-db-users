package com.users_api.controller;

import com.users_api.dto.PostsDto;
import com.users_api.dto.UserDto;
import com.users_api.service.ExternalApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/external/api/users")
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(externalApiService.getUsersFromExternalApi(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(externalApiService.getUserByIdFromExternalApi(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody PostsDto postsDto) {
        externalApiService.createExternalUser(postsDto);
        return new ResponseEntity<>("Posts has been created successfully", HttpStatus.OK);
    }

}
