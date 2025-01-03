package com.users_api.service;

import com.users_api.entity.User;

import java.util.List;

public interface ExternalApiService {

    public List<User> getUsersFromExternalApi();

    public User getUserByIdFromExternalApi(Long id);
}
