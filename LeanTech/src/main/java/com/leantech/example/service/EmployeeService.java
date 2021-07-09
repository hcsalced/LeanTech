package com.leantech.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.example.dto.EmployeeDTO;
import com.leantech.example.model.Employee;
import com.leantech.example.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final PositionService positionService;

	@Autowired
	public EmployeeService(final EmployeeRepository employeeRepository, final PositionService positionService) {
		this.employeeRepository = employeeRepository;
		this.positionService = positionService;
	}

	public Employee get(final int id) {
		final Employee Employee = employeeRepository.getById(id);
		return Employee;
	}

	public List<Employee> getAllByName(final String name) {
		return employeeRepository.findEmployeeWhichIncludeName(name);
	}

	public List<EmployeeDTO> getBuildEmployeeByPosition() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		positionService.getAll().stream().forEach(a -> {
			EmployeeDTO employeeDTO = new EmployeeDTO(a.getId(),a.getName(),getByPosition(a.getId()));
			employeeDTOs.add(employeeDTO);
		});
		return employeeDTOs;
	}

	public List<Employee> getByPosition(final int id) {
		return employeeRepository.findEmployeeWhichIncludePosition(id);
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public void update(final int id, final Employee employee) {
		final Employee employeeFind = get(id);
		employeeFind.setPerson(employee.getPerson());
		employeeFind.setPosition(employee.getPosition());
		employeeFind.setSalary(employee.getSalary());
		employeeRepository.save(employeeFind);
	}

	public void delete(final int employee) {
		final Employee employeeFind = get(employee);
		employeeRepository.delete(employeeFind);
	}

	public void create(final Employee Employee) {
		employeeRepository.save(Employee);
	}
	
}
