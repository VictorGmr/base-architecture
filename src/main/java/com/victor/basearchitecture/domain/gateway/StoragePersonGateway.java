package com.victor.basearchitecture.domain.gateway;

import com.victor.basearchitecture.domain.model.Person;

import java.util.List;

public interface StoragePersonGateway {
    Person create(Person person);
    List<Person> list();
}
