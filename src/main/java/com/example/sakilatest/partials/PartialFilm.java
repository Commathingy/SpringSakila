package com.example.sakilatest.partials;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;


@Entity
@Table(name = "film")
@Getter
@Setter
public class PartialFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private Short id;

    @Column(name="title")
    private String title;

    @Column(name="release_year")
    private Year releaseYear;

}