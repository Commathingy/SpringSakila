package com.example.sakilatest.repositories;

import com.example.sakilatest.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Short> { }