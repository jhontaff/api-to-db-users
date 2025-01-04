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
        addressDto.setGeo(new GeolocationMapper().mapToDto(address.getGeolocation()));
        return addressDto;

    }

    public Address mapToEntity(AddressDto addressDto){
        if(addressDto == null){
            return null;
        }
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setSuite(addressDto.getSuite());
        address.setCity(addressDto.getCity());
        address.setZipcode(addressDto.getZipcode());
        address.setGeolocation(new GeolocationMapper().mapToEntity(addressDto.getGeo()));
        return address;
    }

}
