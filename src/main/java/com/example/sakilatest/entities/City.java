package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "city")
@Getter
public class City {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="city_id")
    private Short id;

    @Column(name="city")
    private String cityName;

    //todo referential country
}