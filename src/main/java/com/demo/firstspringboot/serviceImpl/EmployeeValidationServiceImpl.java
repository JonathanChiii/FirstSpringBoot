package com.demo.firstspringboot.serviceImpl;

import com.demo.firstspringboot.dto.EmployeeRequest;
import com.demo.firstspringboot.exception.EmployeeNotFoundException;
import com.demo.firstspringboot.model.Employee;
import com.demo.firstspringboot.repository.EmployeeRepository;
import com.demo.firstspringboot.service.EmployeeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(EmployeeRequest employeeRequest){
        Employee e = Employee.build(0, employeeRequest.getName(), employeeRequest.getEmail(), employeeRequest.getPassword(), employeeRequest.getSalary());
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) throws EmployeeNotFoundException {
        if(employeeRepository.findById(id).orElse(null) == null){
            throw new EmployeeNotFoundException("Id: " + id + " does not meet any of our records.");
        } else{
            return employeeRepository.findById(id).get();
        }
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }


    @Override
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }



}
