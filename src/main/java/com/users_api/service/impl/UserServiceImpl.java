package com.users_api.service.impl;

import com.users_api.dto.UserDto;
import com.users_api.entity.User;
import com.users_api.exception.UserException;
import com.users_api.mapper.UserMapper;
import com.users_api.repository.UserRepository;
import com.users_api.service.ExternalApiService;
import com.users_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ExternalApiService externalApiService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ExternalApiService externalApiService,
                           UserMapper userMapper,
                           UserRepository userRepository) {
        this.externalApiService = externalApiService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void createUsers() {
        List<UserDto> usersDtos = externalApiService.getUsersFromExternalApi();
        List <User> users = usersDtos.stream().map(userMapper::mapToEntity).toList();

        for (User user : users) {
            if (user != null) {
                userRepository.save(user);
            } else {
                throw new UserException("User cannot be null");
            }
        }

    }
}
