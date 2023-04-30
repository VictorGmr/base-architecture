package com.victor.basearchitecture.domain.model;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private Integer age;

    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
