package com.users_api.service;

import com.users_api.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User createUser(User user);

    public void createUsers(List<User> users);
}
