package com.leantech.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leantech.example.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	 @Query(value =  "SELECT employee " +
             "FROM Employee employee " +
             "WHERE employee.person.name LIKE :name",
     nativeQuery = false
)
List<Employee> findEmployeeWhichIncludeName(final @Param(value = "name") String name);

	 @Query(value =  "SELECT employee " +
             "FROM Employee employee " +
             "WHERE employee.position.id = :id order by employee.salary desc",
     nativeQuery = false
)
List<Employee> findEmployeeWhichIncludePosition(final @Param(value = "id") int id);	 
	 
}
