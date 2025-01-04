package com.users_api.service;

import com.users_api.dto.UserDto;

import java.util.List;

public interface ExternalApiService {

    public List<UserDto> getUsersFromExternalApi();

    public UserDto getUserByIdFromExternalApi(Long id);
}
