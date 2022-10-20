package com.demo.firstspringboot.controller;

import com.demo.firstspringboot.model.Employee;
import com.demo.firstspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
public class Test {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping("/findall")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @RequestMapping("/find{x}")
    public Employee findById(@PathVariable int x){
        return employeeService.findById(x);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Employee employee){
        employeeService.delete(employee);
    }

    @GetMapping("/sayhello")
    public String test(@RequestParam(value = "myName", defaultValue = "Jonathan") String name){
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value={"hello"}, method = RequestMethod.GET)
    public String test3(){
        return "Hello";
    }

    @PostMapping("/register")
    public Employee test2(@RequestBody Employee employee){
        System.out.println(employee.toString());
        return employee;
    }

    @GetMapping("/{x}")
    public ResponseEntity<String> createDate(@PathVariable int x){
        System.out.println("value passed from url = " + x);
        ResponseEntity<String> res = new ResponseEntity<>("Passed param", HttpStatus.OK);
        return res;
    }

}
