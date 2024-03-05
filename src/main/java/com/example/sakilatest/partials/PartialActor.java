package com.example.sakilatest.partials;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "actor")
@Getter
@Setter
public class PartialActor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="actor_id")
    private Short id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
}