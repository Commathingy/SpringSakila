package com.example.sakilatest.input;

import com.example.sakilatest.validation.FullActorValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActorInput {
    @NotNull(groups = {FullActorValidation.Create.class})
    @Size(max = 45)
    private String firstName;

    @NotNull(groups = {FullActorValidation.Create.class})
    @Size(max = 45)
    private String lastName;

    private List<Short> inFilms = new ArrayList<>();
}
