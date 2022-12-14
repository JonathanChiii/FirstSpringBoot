package com.demo.firstspringboot.serviceImpl;

import com.demo.firstspringboot.exception.EmployeeNotFoundException;
import com.demo.firstspringboot.model.Employee;
import com.demo.firstspringboot.repository.EmployeeRepository;
import com.demo.firstspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
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
    public Employee findById(Integer id) throws EmployeeNotFoundException{
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
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee){
        Employee e = employeeRepository.findById(employee.getId()).orElse(null);
        if(e != null){
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setPassword(employee.getPassword());
            e.setSalary(employee.getSalary());
            return employeeRepository.save(e);
        }
        return null;
    }

}
