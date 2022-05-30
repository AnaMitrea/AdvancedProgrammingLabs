package com.example.demo.lab11.entity;

import javax.persistence.*;

@Entity
@Table
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer personId1;
    private Integer personId2;

    public Friendship() { }

    public Friendship(Integer personId1, Integer personId2) {
        this.personId1 = personId1;
        this.personId2 = personId2;
    }

    public Friendship(Integer id, Integer personId1, Integer personId2) {
        this.id = id;
        this.personId1 = personId1;
        this.personId2 = personId2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId1() {
        return personId1;
    }

    public void setPersonId1(Integer personId1) {
        this.personId1 = personId1;
    }

    public Integer getPersonId2() {
        return personId2;
    }

    public void setPersonId2(Integer personId2) {
        this.personId2 = personId2;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", personId1=" + personId1 +
                ", personId2=" + personId2 +
                '}';
    }
}