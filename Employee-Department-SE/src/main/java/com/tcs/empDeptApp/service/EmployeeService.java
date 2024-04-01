package com.tcs.empDeptApp.service;

import com.tcs.empDeptApp.exception.EmployeeAlreadyExistsException;
//import com.dailycodework.sbrdemo.exception.EmployeeAlreadyExistsException;
//import com.dailycodework.sbrdemo.exception.EmployeeNotFoundException;
import com.tcs.empDeptApp.exception.EmployeeNotFoundException;
import com.tcs.empDeptApp.model.Employee;
import com.tcs.empDeptApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService
{
    private final EmployeeRepository employeeRepository;




    @Override
    public Employee addEmployee(Employee employee)
    {
        if(employeeAlreadyExists(employee.getEmail()))
        {
            throw new EmployeeAlreadyExistsException(employee.getEmail()+"Already Exists ");
        }
        return employeeRepository.save(employee);

    }




    @Override
    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }




    //UPDATE
    @Override
    public Employee updateEmployee(Employee employee, Long id)
    {
        return employeeRepository.findById(id).map(st -> {
            st.setFirstName(employee.getFirstName());
            st.setLastName(employee.getLastName());
            st.setEmail(employee.getEmail());
            st.setDepartment(employee.getDepartment());
            return employeeRepository.save(st);
        }).orElseThrow(() -> new EmployeeNotFoundException("Sorry, this employee could not be found"));

    }




    // GET EMPLOYEE
    @Override
    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Sorry, no employee found with the Id :" +id));
    }


    // DELETE EMPLOYEE:
    @Override
    public void deleteEmployee(Long id)
    {
        if (!employeeRepository.existsById(id))
        {
            throw new EmployeeNotFoundException("Sorry, employee not found");
        }
        employeeRepository.deleteById(id);
    }




    private boolean employeeAlreadyExists(String email)
    {
        return employeeRepository.findByEmail(email).isPresent();
    }



}
