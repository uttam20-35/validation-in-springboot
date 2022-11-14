package com.example.validation.controller;

import com.example.validation.model.PersonModel;
import com.example.validation.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@Log4j2
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping (path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonModel> createEmployee(@RequestBody @Valid PersonModel personModel) {
        if (Objects.isNull(personModel) != true){
            personModel  =personService .createEmployee(personModel);
            log.info("Person Model is not null!!!");
        }else{
            log.info("Cannot Pass null objects");
        }
        return new ResponseEntity<>(personModel, HttpStatus.OK);
    }

}