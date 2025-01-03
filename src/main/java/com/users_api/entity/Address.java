package com.users_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "geolocation_id")
    private Geolocation geolocation;

    @OneToOne(mappedBy = "address")
    private User user;
}
