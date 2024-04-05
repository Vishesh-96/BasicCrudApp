package com.example.basiccrud.Service;

import com.example.basiccrud.EmployeeRepository;
import com.example.basiccrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws Exception {
        return employeeRepository.findById(id).orElseThrow(() -> new Exception(new Exception()));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) throws Exception {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        return employeeRepository.save(employee);
    }

    public ResponseEntity<?> deleteEmployee(Long id) throws Exception {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }

    public List<Employee> createEmployeeAll(List<Employee> employees) {
        List<Employee> createdEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            createdEmployee.add(employeeRepository.save(employee));
        }
        return createdEmployee;
    }
}
