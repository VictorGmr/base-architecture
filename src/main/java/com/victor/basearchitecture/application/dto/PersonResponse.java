package com.victor.basearchitecture.application.dto;

import com.victor.basearchitecture.domain.model.Person;
import lombok.Data;

@Data
public class PersonResponse {
    Long id;
    String name;
    Integer age;

    PersonResponse(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static PersonResponse personToDto(Person person) {
        return new PersonResponse(
            person.getId(),
            person.getName(),
            person.getAge()
        );
    }
}
