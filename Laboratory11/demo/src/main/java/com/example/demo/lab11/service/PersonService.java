package com.example.demo.lab11.service;

import com.example.demo.lab11.entity.Person;
import com.example.demo.lab11.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Integer personId) {
        return personRepository.findById(personId);
    }

    public void addNewPerson(Person person) {
        try{
            if(person.getName().isEmpty()) {
                throw new Exception("Empty name field");
            }
            Optional<Person> personOptional = personRepository.findPersonById(person.getId());
            if(personOptional.isPresent()) {
                throw new IllegalStateException("Id already Exists");
            }
            personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(Integer personId) {
        try {
            boolean exists = personRepository.existsById(personId);
            if(!exists) {
                throw new IllegalStateException("Person with id " + personId + " does not exist.");
            }
            personRepository.deleteById(personId);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updatePerson(Integer personId, String name, Integer age) {
        try {
            Person person = personRepository.findById(personId)
                    .orElseThrow(() -> new IllegalStateException("Person with id " + personId + " does not exist."));

            if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)) {
                person.setName(name);
            }

            if (age != null && age.compareTo(0) > 0 && !Objects.equals(person.getAge(), age)) {
                person.setAge(age);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
