package com.example.sakilatest.repositories;

import com.example.sakilatest.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ActorRepo extends JpaRepository<Actor, Short> {

    @Query(value="SELECT * FROM actor WHERE first_name = :name LIMIT 1", nativeQuery=true)
    Optional<Actor> findActorByName(String name);

}
