package com.users_api.mapper;

import com.users_api.dto.GeolocationDto;
import com.users_api.entity.Geolocation;

public class GeolocationMapper {

    public GeolocationDto mapToDto(Geolocation geolocation){
        if(geolocation == null){
            return null;
        }
        GeolocationDto geolocationDto = new GeolocationDto();
        geolocationDto.setLat(geolocation.getLat());
        geolocationDto.setLng(geolocation.getLng());
        return geolocationDto;

    }

    public Geolocation mapToEntity(GeolocationDto geolocationDto){
        if(geolocationDto == null){
            return null;
        }
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(geolocationDto.getLat());
        geolocation.setLng(geolocationDto.getLng());
        return geolocation;
    }
}
