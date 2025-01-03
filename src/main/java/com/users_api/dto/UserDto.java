package com.users_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        private Long id;
        private String name;
        private String username;
        private String email;
        private AddressDto addressDto;
        private String phone;
        private String website;
        private CompanyDto companyDto;
}
