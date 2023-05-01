package com.victor.basearchitecture.infrastructure.entity;

import com.victor.basearchitecture.domain.model.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private OffsetDateTime created_at;

    private OffsetDateTime updated_at;

    public PersonEntity(
        Long id,
        String name,
        Integer age,
        OffsetDateTime created_at,
        OffsetDateTime updated_at
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PersonEntity() {

    }

    public Person toDomain() {
        return new Person(this.id, this.name, this.age);
    }

    public static PersonEntity build(Person person) {
        return new PersonEntity(
            null,
            person.getName(),
            person.getAge(),
            OffsetDateTime.now(),
            OffsetDateTime.now()
        );
    }
}
