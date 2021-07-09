package com.leantech.example.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.leantech.example.model.Employee;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private List<Employee> employees;

	public EmployeeDTO(final int id, final String name, final List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.employees = employees.stream().map(a -> new Employee(a.getId(), a.getPerson(), null, a.getSalary()))
				.collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
