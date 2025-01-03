package com.users_api.mapper;

import com.users_api.dto.AddressDto;
import com.users_api.entity.Address;

public class AddressMapper {

    public AddressDto mapToDto(Address address){
        if(address == null){
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setSuite(address.getSuite());
        addressDto.setCity(address.getCity());
        addressDto.setZipcode(address.getZipcode());
        return addressDto;

    }
}
