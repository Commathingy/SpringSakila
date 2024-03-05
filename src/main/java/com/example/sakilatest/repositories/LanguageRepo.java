package com.example.sakilatest.repositories;

import com.example.sakilatest.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language, Short> { }
