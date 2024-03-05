package com.example.sakilatest.controllers;

import com.example.sakilatest.entities.Film;
import com.example.sakilatest.repositories.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    FilmRepo filmRepo;
    @GetMapping("/films")
    public List<Film> listFilms() {
            return filmRepo.findAll();
    }

    @GetMapping("/films/{id}")
    public Film getFilmByID(@PathVariable Short id) {
        return filmRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No film found with id " + id));
    }
}
