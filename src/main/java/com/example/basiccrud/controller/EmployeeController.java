package com.example.basiccrud.controller;

import com.example.basiccrud.Service.EmployeeService;
import com.example.basiccrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) throws Exception {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/batch")
    public List<Employee> createEmployeeArray(@RequestBody List<Employee> employee) {
        return employeeService.createEmployeeAll(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employeeDetails) throws Exception {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id) throws Exception {
        return employeeService.deleteEmployee(id);
    }
}
