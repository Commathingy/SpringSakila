package com.example.sakilatest.repositories;

import com.example.sakilatest.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor, Short> { }
