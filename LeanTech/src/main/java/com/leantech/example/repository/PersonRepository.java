package com.leantech.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leantech.example.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
