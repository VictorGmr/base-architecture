package com.victor.basearchitecture.domain.service;

import com.victor.basearchitecture.domain.gateway.StoragePersonGateway;
import com.victor.basearchitecture.domain.model.Person;

import java.util.List;

public class ListPersonService {

    StoragePersonGateway storagePersonGateway;

    public ListPersonService(StoragePersonGateway storagePersonGateway) {
        this.storagePersonGateway = storagePersonGateway;
    }

    public List<Person> execute() {
        return storagePersonGateway.list();
    }
}
