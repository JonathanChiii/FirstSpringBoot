package com.demo.firstspringboot.serviceImpl;

import com.demo.firstspringboot.model.Employee;
import com.demo.firstspringboot.repository.EmployeeRepository;
import com.demo.firstspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id){
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }
}
