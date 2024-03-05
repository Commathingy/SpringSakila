package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "category")
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="category_id")
    private Byte id;

    @Column(name="name")
    private String categoryName;
}