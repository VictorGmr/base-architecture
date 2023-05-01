package com.victor.basearchitecture.domain.service.factory;

import com.victor.basearchitecture.domain.model.Person;

public class PersonFactory {

    public static Person build() {
        return new Person(
            1L,
            "name",
            20
        );
    }
}
