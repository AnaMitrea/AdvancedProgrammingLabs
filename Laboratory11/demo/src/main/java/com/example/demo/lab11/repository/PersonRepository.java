package com.example.demo.lab11.repository;

import com.example.demo.lab11.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Optional<Person> findPersonById(Integer id);

}
