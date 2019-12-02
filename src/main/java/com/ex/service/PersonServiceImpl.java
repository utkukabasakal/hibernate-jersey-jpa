package com.ex.service;

import com.ex.dao.PersonDAO;
import com.ex.model.Person;
import com.ex.dao.PersonDAOImpl;

import java.util.ArrayList;

public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public PersonServiceImpl() throws ClassNotFoundException {
        this.personDAO = new PersonDAOImpl();
    }

    @Override
    public Person findbyId(int personId) {
        return personDAO.findbyId(personId);
    }

    @Override
    public ArrayList<Person> findAll() {
        return (ArrayList<Person>) personDAO.findAll();
    }

    @Override
    public void insert(Person person) {
        personDAO.insert(person);
    }

    @Override
    public void update(Person person) {
        personDAO.update(person);
    }

    @Override
    public void delete(int personId) {
        personDAO.deleteById(personId);
    }

    @Override
    public void deleteById(Person person) {
        personDAO.delete(person);
    }
}