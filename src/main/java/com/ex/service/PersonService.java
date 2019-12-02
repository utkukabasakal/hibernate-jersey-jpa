package com.ex.service;

import com.ex.model.Person;

import java.util.ArrayList;

public interface PersonService {

    public Person findbyId(int personId);

    public ArrayList<Person> findAll();

    public void insert(Person person);

    public void update(Person person);

    public void delete(int personId);

    public void deleteById(Person person);

}