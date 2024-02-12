package kea.exercise.person.controller;


import kea.exercise.person.model.Person;
import kea.exercise.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
     Optional<Person> person = personRepository.findById(id);
    return ResponseEntity.of(person);
//     if(person.isPresent()){
//         return ResponseEntity.ok(person.get());
//
//     }else {
//         return ResponseEntity.notFound().build();
//     }
//     return person.orElse(null);
//     if(person.isPresent()) {
//         return person.get();
//     } else {
//         return null;
//     }
//     }
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

    @PostMapping("persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person ){
        return personRepository.save(person);

    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person){
        Optional<Person> original = personRepository.findById(id);
        if(original.isPresent()){
            Person originalPerson = original.get();
            //update OP
            originalPerson.setFirstName(person.getFirstName());
            originalPerson.setLastName(person.getLastName());
            originalPerson.setDateOfBirth(person.getDateOfBirth());
            Person updatedPerson = personRepository.save(originalPerson);
            return ResponseEntity.ok().body(updatedPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    

}
