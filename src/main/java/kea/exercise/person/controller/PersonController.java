package kea.exercise.person.controller;


import kea.exercise.person.model.Person;
import kea.exercise.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
//        var person1 = new Person();
//        person1.setId(9);
//        person1.setFirstName("DUMMY");
//        person1.setLastName("TEST");
//        person1.setDateOfBirth(LocalDate.parse("1970-01-01"));
//
//        var person2 = new Person();
//        person2.setId(10);
//        person2.setFirstName("ANOTHER");
//        person2.setLastName("TESTPERSON");
//        person2.setDateOfBirth(LocalDate.parse("2024-01-01"));
//
//        List<Person> persons = new ArrayList<>();
//
//        persons.add(person1);
//        persons.add(person2);

        List<Person> persons = personRepository.findAll();
        return persons;



    }
}
