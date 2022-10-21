package com.demo.firstspringboot.service;

import com.demo.firstspringboot.exception.EmployeeNotFoundException;
import com.demo.firstspringboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee e);
    List<Employee> findAll();
    Employee findById(Integer id) throws EmployeeNotFoundException;
    Employee findByName(String name);
    void delete(Employee employee);
    void deleteById(Integer id);
    Employee update(Employee employee);
}
