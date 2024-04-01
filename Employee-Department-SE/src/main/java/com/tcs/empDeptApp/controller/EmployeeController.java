package com.tcs.empDeptApp.controller;

import com.tcs.empDeptApp.model.Employee;
import com.tcs.empDeptApp.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin("http://localhost:3000") //allowing client application to consume the backend
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController
{
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees()
    {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.FOUND);
    }


    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.updateEmployee(employee, id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }



    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }


}
