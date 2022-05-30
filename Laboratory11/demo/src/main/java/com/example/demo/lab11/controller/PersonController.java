package com.example.demo.lab11.controller;

import com.example.demo.lab11.entity.Person;
import com.example.demo.lab11.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "{personId}")
    public Optional<Person> getPersons(@PathVariable Integer personId) {
        return personService.getPerson(personId);
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Integer personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age) {
        personService.updatePerson(personId, name, age);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Integer personId) {
        personService.deletePerson(personId);
    }
}
