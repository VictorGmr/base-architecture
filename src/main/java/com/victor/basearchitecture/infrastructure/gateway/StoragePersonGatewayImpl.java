package com.victor.basearchitecture.infrastructure.gateway;

import com.victor.basearchitecture.domain.gateway.StoragePersonGateway;
import com.victor.basearchitecture.domain.model.Person;
import com.victor.basearchitecture.infrastructure.entity.PersonEntity;
import com.victor.basearchitecture.infrastructure.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoragePersonGatewayImpl implements StoragePersonGateway {

    PersonRepository personRepository;

    StoragePersonGatewayImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(PersonEntity.build(person)).toDomain();
    }

    @Override
    public List<Person> list() {
        return personRepository.findAll()
                .stream()
                .map(PersonEntity::toDomain)
                .collect(Collectors.toList());
    }
}
