package com.leantech.example.controller;

import com.leantech.example.dto.EmployeeDTO;
import com.leantech.example.model.Employee;
import com.leantech.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/employee"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(final EmployeeService EmployeeService) {
        this.employeeService = EmployeeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable final int id) {
        return new ResponseEntity<>(employeeService.get(id), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/allEmployee")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/allEmployee/{name}")
    public List<Employee> getAllByName(@PathVariable final String name) {
        return employeeService.getAllByName(name);
    }
    
    @GetMapping("/allByPosition")
    public List<EmployeeDTO> getAllByPosition() {
        return employeeService.getBuildEmployeeByPosition();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final int id,@RequestBody Employee employee) {
        employeeService.update(id,employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        employeeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
