package com.example.sakilatest.validation;

import jakarta.validation.groups.Default;

public class FullActorValidation {

    public static final Class<? extends Default> create = Create.class;
    public static final Class<? extends Default> update = Create.class;

    public interface Create extends Default {
    }

    public interface Update extends Default {
    }
}