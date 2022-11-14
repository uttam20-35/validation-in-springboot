package com.example.validation.service;

import com.example.validation.entity.PersonEntity;
import com.example.validation.mapper.PersonMapper;
import com.example.validation.model.PersonModel;
import com.example.validation.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    public PersonModel createEmployee(PersonModel personModel) {
        PersonEntity personEntity = personMapper.modelToEntity(personModel);
        personRepository.save(personEntity);
        log.info("Created Employee Successfully!!");
        return personModel;
    }
}