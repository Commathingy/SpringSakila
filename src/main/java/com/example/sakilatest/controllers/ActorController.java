package com.example.sakilatest.controllers;

import com.example.sakilatest.entities.Actor;
import com.example.sakilatest.input.ActorInput;
import com.example.sakilatest.services.ActorService;
import com.example.sakilatest.validation.FullActorValidation;
import com.example.sakilatest.validation.PartialActorValidation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @GetMapping("/actors")
    public List<Actor> listActors() {
        return actorService.listAll();
    }

    @GetMapping("/actors/{id}")
    public Actor getActorByID(@PathVariable Short id) {
        return actorService.getById(id);
    }

    @PostMapping("/actors")
    public Actor createActor(@Validated(FullActorValidation.Create.class) @RequestBody ActorInput data){
        return actorService.addActor(data);
    }

    @PatchMapping("/actors/{id}")
    public Actor patchActor(
            @PathVariable Short id,
            @RequestBody ActorInput data
    ){
        validator.validate(data, PartialActorValidation.Create.class);
        return actorService.updateById(id, data);
    }

    @DeleteMapping("/actors/{id}")
    public String deleteActor(
            @PathVariable Short id
    ){
        actorService.deleteById(id);
        return "Successfully removed actor with id: " + id;
    }

    //maybe have to remove the @validated?
    //https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-validation.html
    //@ExceptionHandler
    //public ResponseEntity<String> handle(IOException ex) {
    //    ex.
    //}
}
