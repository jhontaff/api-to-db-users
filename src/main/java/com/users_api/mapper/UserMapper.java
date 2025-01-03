package com.users_api.mapper;

import com.users_api.dto.AddressDto;
import com.users_api.dto.UserDto;
import com.users_api.entity.User;

public class UserMapper {

    private final AddressDto addressDto;

    private UserMapper(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public UserDto mapToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getEmail(),
                addressDto.mapToEntity(user.getAddress()), user.getPhone(), user.getWebsite(), user.getCompany());
    }
}
