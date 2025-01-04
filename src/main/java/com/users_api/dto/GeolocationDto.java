package com.users_api.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class GeolocationDto {

        private String lat;
        private String lng;

        public String getLat() {
                return lat;
        }

        public void setLat(String lat) {
                this.lat = lat;
        }

        public String getLng() {
                return lng;
        }

        public void setLng(String lng) {
                this.lng = lng;
        }
}
