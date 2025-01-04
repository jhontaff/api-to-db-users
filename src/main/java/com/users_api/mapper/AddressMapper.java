package com.users_api.mapper;

import com.users_api.dto.AddressDto;
import com.users_api.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private final GeolocationMapper geolocationMapper;

    public AddressMapper(GeolocationMapper geolocationMapper) {
        this.geolocationMapper = geolocationMapper;
    }


    public AddressDto mapToDto(Address address){
        if(address == null){
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setSuite(address.getSuite());
        addressDto.setCity(address.getCity());
        addressDto.setZipcode(address.getZipcode());
        addressDto.setGeo(geolocationMapper.mapToDto(address.getGeolocation()));
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
        address.setGeolocation(geolocationMapper.mapToEntity(addressDto.getGeo()));
        return address;
    }

}
