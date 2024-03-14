package com.tcs.EmployeeDeptapp.Controller;

import com.tcs.EmployeeDeptapp.model.Employee;
import com.tcs.EmployeeDeptapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/get-employee")
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }


    @PostMapping("/add-employee")
    public String addEmployee(@RequestBody Employee employee)
    {
       return employeeService.addEmployee(employee);
    }

    @PutMapping("/update-employee")
    public String updateEmployee(@RequestParam String name , @RequestParam double salary)
    {
        return employeeService.updateEmployee(name,salary);
    }


    @DeleteMapping("/delete-employee")
    public String deleteEmployee(@RequestParam String name)
    {
       return employeeService.deleteEmployee(name);
    }
}
