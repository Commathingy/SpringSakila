package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Short id;

    //todo referential store_id

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //todo referential address

    @Column(name="active")
    private Boolean isActive;

    @Column(name="create_date")
    private Date creationDate;
}
