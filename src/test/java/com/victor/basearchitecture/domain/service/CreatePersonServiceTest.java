package com.victor.basearchitecture.domain.service;

import com.victor.basearchitecture.domain.gateway.StoragePersonGateway;
import com.victor.basearchitecture.domain.model.Person;
import com.victor.basearchitecture.domain.service.factory.PersonFactory;
import com.victor.basearchitecture.infrastructure.gateway.StoragePersonGatewayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatePersonServiceTest {

    private final StoragePersonGateway storagePersonGateway = mock(StoragePersonGatewayImpl.class);

    private final CreatePersonService createPersonService = new CreatePersonService(storagePersonGateway);

    @Test
    public void canCreatePerson() {
        Person person = PersonFactory.build();
        when(storagePersonGateway.create(person)).thenReturn(person);

        Assertions.assertDoesNotThrow(() -> createPersonService.execute(person));
        verify(storagePersonGateway, times(1)).create(person);
    }
}
