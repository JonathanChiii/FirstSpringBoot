package com.demo.firstspringboot.controller;

import com.demo.firstspringboot.dto.EmployeeRequest;
import com.demo.firstspringboot.exception.EmployeeNotFoundException;
import com.demo.firstspringboot.model.Employee;
import com.demo.firstspringboot.service.EmployeeService;
import com.demo.firstspringboot.service.EmployeeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeValidationService employeeValidationService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/find/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/findid/{x}")
    public Employee findById(@PathVariable int x) throws EmployeeNotFoundException {
        return employeeService.findById(x);
    }

    @GetMapping("/findname/{x}")
    public Employee findByName(@PathVariable String x){
        return employeeService.findByName(x);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Employee employee){
        employeeService.delete(employee);
    }

    @DeleteMapping("/delete/{x}")
    public void deleteById(@PathVariable int x){
        employeeService.deleteById(x);
    }

    @PostMapping("/update")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @PostMapping("/save/valid")
    public EmployeeRequest saveValidation(@RequestBody @Valid EmployeeRequest empReq){
        // valid annotation will check if the object satisfied the constraints in the EmployeeRequest,
        // if invalid, it will hand over to the exception handler.
        // server side validation
        employeeValidationService.save(empReq);
        //return "@redirect:/save";
        return empReq;
    }

    @PostMapping("/register")
    public Employee test2(@RequestBody Employee employee){
        System.out.println(employee.toString());
        return employee;
    }

    @GetMapping("/sayhello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "Jonathan") String name){
        return String.format("Hello %s!", name);
    }
    @GetMapping("/{x}")
    public ResponseEntity<String> createDate(@PathVariable int x){
        System.out.println("value passed from url = " + x);
        ResponseEntity<String> res = new ResponseEntity<>("Passed param", HttpStatus.OK);
        return res;
    }

}
