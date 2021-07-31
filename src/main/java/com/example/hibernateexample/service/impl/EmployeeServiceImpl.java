package com.example.hibernateexample.service.impl;

import com.example.hibernateexample.exception.ResourceNotFoundException;
import com.example.hibernateexample.model.Employee;
import com.example.hibernateexample.repository.EmployeeRepository;
import com.example.hibernateexample.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        throw new ResourceNotFoundException("Employee", "ID", id.toString());
    }

    @Override
    public Employee update(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "ID", id.toString())
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(employee);
        return existingEmployee;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "ID", id.toString())
        );
        employeeRepository.deleteById(id);
    }
}
