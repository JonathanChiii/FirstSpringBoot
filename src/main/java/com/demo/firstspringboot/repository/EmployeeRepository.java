package com.demo.firstspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.firstspringboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // <Employee> class name
    // <Integer> type of primary key
}
