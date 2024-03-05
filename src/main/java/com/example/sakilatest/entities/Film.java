package com.example.sakilatest.entities;


import com.example.sakilatest.partials.PartialActor;
import com.example.sakilatest.partials.PartialFilm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private Short id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    //todo category, length, rating, special features, in stores


    @Column(name="release_year")
    private Year releaseYear;

    @ManyToMany
    @JoinTable(
            name="film_actor",
            joinColumns = {@JoinColumn(name="film_id")},
            inverseJoinColumns = {@JoinColumn(name="actor_id")}
    )
    private List<PartialActor> cast = new ArrayList<>();

    @Column(name="rental_duration")
    private byte rentalDuration;

    @Column(name="rental_rate")
    private BigDecimal rentalRate;

    @Column(name="replacement_cost")
    private BigDecimal replacementCost;

    @OneToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    private Language originalLanguage;

    public PartialFilm toPartial(){
        PartialFilm partial = new PartialFilm();
        partial.setId(this.id);
        partial.setTitle(this.title);
        partial.setReleaseYear(this.releaseYear);
        return partial;
    }
}