package com.demo.firstspringboot.service;

import com.demo.firstspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee e);
    List<Employee> findAll();
    Employee findById(Integer id);
    void delete(Employee employee);
}
