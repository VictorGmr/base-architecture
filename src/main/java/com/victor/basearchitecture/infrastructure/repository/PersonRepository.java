package com.victor.basearchitecture.infrastructure.repository;

import com.victor.basearchitecture.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
