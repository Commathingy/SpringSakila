package com.example.sakilatest.controllers;

import com.example.sakilatest.entities.Actor;
import com.example.sakilatest.input.ActorInput;
import com.example.sakilatest.partials.PartialFilm;
import com.example.sakilatest.services.ActorService;
import com.example.sakilatest.validation.FullActorValidation;
import com.example.sakilatest.validation.PartialActorValidation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public ActorController(){}

    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> listActors(
            @RequestParam(required = false) String firstName
    ) {
        if (firstName != null) {
            return actorService.listAllFiltered(firstName.toUpperCase());
        }
        else{
            return actorService.listAll();
        }
    }

    @GetMapping("/actors/search")
    public Optional<Actor> searchByName(
            @RequestParam(required = false) String firstName
    ) {
        if (firstName != null) {
            return actorService.getByName(firstName.toUpperCase());
        }
        else{
            return Optional.empty();
        }
    }

    @GetMapping("/actors/{id}")
    public Actor getActorByID(@PathVariable Short id) {
        return actorService.getById(id);
    }

    @GetMapping("/actors/{id}/films")
    public List<PartialFilm> getActorsFilms(@PathVariable Short id){
        return actorService.getById(id).getInFilms();
    }



    @PostMapping("/actors")
    public Actor createActor(@Validated(FullActorValidation.Create.class) @RequestBody ActorInput data){
        return actorService.addActor(data);
    }




    @PatchMapping("/actors/{id}")
    public Actor patchActor(
            @PathVariable Short id,
            @Validated(PartialActorValidation.Create.class) @RequestBody ActorInput data
    ){
        return actorService.updateById(id, data);
    }



    @PatchMapping("/actors/{id}/films/push")
    public Actor addFilmtoActor(
            @PathVariable Short id,
            @Validated(PartialActorValidation.Create.class) @RequestBody ActorInput data
    ) {
        return actorService.addFilmByID(id, data);
    }




    @DeleteMapping("/actors/{id}")
    public String deleteActor(
            @PathVariable Short id
    ){
        actorService.deleteById(id);
        return "Successfully removed actor with id: " + id;
    }



    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseStatusException handleConstraintException(MethodArgumentNotValidException e) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

}
