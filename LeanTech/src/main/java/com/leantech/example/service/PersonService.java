package com.leantech.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.example.model.Person;
import com.leantech.example.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    
    @Autowired
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(final int id) {
        final Person person = personRepository.getById(id);
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void update(final int id) {
    	final Person personFind = get(id);
    	personRepository.save(personFind);
    }

    public void delete(final int person) {
    	final Person personFind = get(person);
        personRepository.delete(personFind);
    }
    
    public void create(final Person person) {
        personRepository.save(person);
    }
}
