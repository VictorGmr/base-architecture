package com.victor.basearchitecture.application.controller;

import com.victor.basearchitecture.application.dto.CreatePersonRequest;
import com.victor.basearchitecture.application.dto.PersonResponse;
import com.victor.basearchitecture.domain.service.CreatePersonService;
import com.victor.basearchitecture.domain.service.ListPersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping({"/person"})
public class PersonController {

    CreatePersonService createPersonService;
    ListPersonService listPersonService;

    @PostMapping
    ResponseEntity<PersonResponse> create(@RequestBody CreatePersonRequest createPersonRequest) {
        return new ResponseEntity<>(
            PersonResponse.personToDto(createPersonService.execute(createPersonRequest.toDomain())),
            HttpStatus.CREATED
        );
    }

    @GetMapping
    ResponseEntity<List<PersonResponse>> listAllPerson() {
        return new ResponseEntity<>(
            listPersonService.execute()
                .stream()
                .map(PersonResponse::personToDto)
                .collect(Collectors.toList()),
            HttpStatus.OK
        );
    }

}
