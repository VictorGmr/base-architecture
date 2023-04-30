package com.victor.basearchitecture.domain.service;

import com.victor.basearchitecture.domain.gateway.StoragePersonGateway;
import com.victor.basearchitecture.domain.model.Person;

public class CreatePersonService {

    StoragePersonGateway storagePersonGateway;

    public CreatePersonService(StoragePersonGateway storagePersonGateway) {
        this.storagePersonGateway = storagePersonGateway;
    }

    public Person execute(Person person) {
        return storagePersonGateway.create(person);
    }
}
