package com.victor.basearchitecture.application.dto;

import com.victor.basearchitecture.domain.model.Person;
import lombok.Data;

@Data
public class CreatePersonRequest {
    String name;
    Integer age;

    public Person toDomain() {
        return new Person(null, name, age);
    }
}
