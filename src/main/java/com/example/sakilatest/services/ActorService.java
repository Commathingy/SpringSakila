package com.example.sakilatest.services;

import com.example.sakilatest.entities.Actor;
import com.example.sakilatest.entities.Film;
import com.example.sakilatest.input.ActorInput;
import com.example.sakilatest.repositories.ActorRepo;
import com.example.sakilatest.repositories.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    FilmRepo filmRepo;

    @Autowired
    ActorRepo actorRepo;


    public List<Actor> listAll() {
        return actorRepo.findAll();
    }

    public Actor getById(Short id){
        return actorRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No actor found with id " + id));
    }

    public void deleteById(Short id){
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new ResourceAccessException("No actor found with id " + id));
        actorRepo.deleteById(id);
    }

    public Actor addActor(ActorInput data){
        Actor actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        if (data.getInFilms() != null) {
            List<Film> films = filmRepo.findAllById(data.getInFilms());
            actor.setInFilms(films.stream().map(Film::toPartial).collect(Collectors.toList()));
        }
        actorRepo.save(actor);
        return actor;
    }

    public Actor updateById(Short id, ActorInput data){
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new ResourceAccessException("No actor found with id " + id));
        if (data.getFirstName() != null) {
            actor.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            actor.setLastName(data.getLastName());
        }
        if (data.getInFilms() != null) {
            List<Film> films = filmRepo.findAllById(data.getInFilms());
            actor.setInFilms(films.stream().map(Film::toPartial).collect(Collectors.toList()));
        }
        actorRepo.save(actor);
        return actor;
    }
}
