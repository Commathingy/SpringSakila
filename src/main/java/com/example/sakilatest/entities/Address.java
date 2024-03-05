package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "language")
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="address_id")
    private Short id;

    @Column(name="address")
    private String addressOne;

    @Column(name="address2")
    private String addressTwo;

    @Column(name="district")
    private String district;

    //todo Referential:
    @Column(name="city_id")
    private Short cityId;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;


    //Todo: Location is "geometry" data type
}