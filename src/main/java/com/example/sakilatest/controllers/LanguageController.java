package com.example.sakilatest.controllers;

import com.example.sakilatest.entities.Language;
import com.example.sakilatest.repositories.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    LanguageRepo langRepo;

    @GetMapping
    public List<Language> listFilms() {
        return langRepo.findAll();
    }
}
