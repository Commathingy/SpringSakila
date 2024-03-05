package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "country")
@Getter
public class Country {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="country_id")
    private Short id;

    @Column(name="country")
    private String countryName;
}
