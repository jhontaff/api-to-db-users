package com.users_api.mapper;

import com.users_api.dto.AddressDto;
import com.users_api.dto.UserDto;
import com.users_api.entity.User;

public class UserMapper {

    public UserDto mapToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(new AddressMapper().mapToDto(user.getAddress()));
        userDto.setPhone(user.getPhone());
        userDto.setWebsite(user.getWebsite());
        userDto.setCompany(new CompanyMapper().mapToDto(user.getCompany()));
        return userDto;
    }

    public User mapToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAddress(new AddressMapper().mapToEntity(userDto.getAddress()));
        user.setPhone(userDto.getPhone());
        user.setWebsite(userDto.getWebsite());
        user.setCompany(new CompanyMapper().mapToEntity(userDto.getCompany()));
        return user;
    }
}
