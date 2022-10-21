package com.demo.firstspringboot.service;

import com.demo.firstspringboot.dto.EmployeeRequest;
import com.demo.firstspringboot.exception.EmployeeNotFoundException;
import com.demo.firstspringboot.model.Employee;

import java.util.List;

public interface EmployeeValidationService {
    Employee save(EmployeeRequest e);
    List<Employee> findAll();
    Employee findById(Integer id) throws EmployeeNotFoundException;
    Employee findByName(String name);
    void deleteById(Integer id);
}
