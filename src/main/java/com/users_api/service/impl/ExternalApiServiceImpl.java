package com.users_api.service.impl;

import com.users_api.dto.PostsDto;
import com.users_api.dto.UserDto;
import com.users_api.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private final RestTemplate restTemplate;

    @Value("${users.api.url}")
    private String usersApiUrl;

    @Value("${posts.api.url}")
    private String postsApiUrl;

    public ExternalApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<UserDto> getUsersFromExternalApi() {
        UserDto[] userDtos = restTemplate.getForObject(usersApiUrl, UserDto[].class);
        if (userDtos != null) {
            return Arrays.asList(userDtos);
        }
        return Collections.emptyList();
    }

    @Override
    public UserDto getUserByIdFromExternalApi(Long id) {
        return restTemplate.getForObject(usersApiUrl + "/" + id, UserDto.class);
    }

    @Override
    public void createExternalUser(PostsDto postsDto) {
        restTemplate.postForObject(postsApiUrl, postsDto, PostsDto.class);
    }
}
