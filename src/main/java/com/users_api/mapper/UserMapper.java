package com.users_api.mapper;

import com.users_api.dto.UserDto;
import com.users_api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final AddressMapper addressMapper;
    private final CompanyMapper companyMapper;

    public UserMapper(AddressMapper addressMapper, CompanyMapper companyMapper) {
        this.addressMapper = addressMapper;
        this.companyMapper = companyMapper;
    }

    public UserDto mapToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(addressMapper.mapToDto(user.getAddress()));
        userDto.setPhone(user.getPhone());
        userDto.setWebsite(user.getWebsite());
        userDto.setCompany(companyMapper.mapToDto(user.getCompany()));
        return userDto;
    }

    public User mapToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAddress(addressMapper.mapToEntity(userDto.getAddress()));
        user.setPhone(userDto.getPhone());
        user.setWebsite(userDto.getWebsite());
        user.setCompany(companyMapper.mapToEntity(userDto.getCompany()));
        return user;
    }
}
