package com.example.hibernateexample.controller;

import com.example.hibernateexample.model.Employee;
import com.example.hibernateexample.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Employee> get(){
        return employeeService.get();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.get(id), HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.update(employee, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(id.toString(), HttpStatus.OK);
    }
}
