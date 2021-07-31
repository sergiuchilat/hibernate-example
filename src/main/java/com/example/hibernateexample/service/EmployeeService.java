package com.example.hibernateexample.service;

import com.example.hibernateexample.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    List<Employee> get();
    Employee get(Long id);
    Employee update(Employee employee, Long id);
    void delete(Long id);
}
