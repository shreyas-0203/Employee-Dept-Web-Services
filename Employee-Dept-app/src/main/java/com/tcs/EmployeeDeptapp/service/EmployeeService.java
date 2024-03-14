package com.tcs.EmployeeDeptapp.service;

import com.tcs.EmployeeDeptapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService
{
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public String addEmployee(Employee employee)
    {
        employees.add(employee);
        return "Employee Added Successfully";

    }




    public String updateEmployee(String name, double salary)
    {
        boolean isUpdate = false;

        for(int i = 0 ; i < employees.size() ; i++)
        {
            if(employees.get(i).getFirstName().equals(name) || employees.get(i).getLastName().equals(name))
            {
                employees.get(i).setSalary(salary);
                isUpdate = true;
                break;
            }
        }

        if(isUpdate) return "Employee Updated SuccessFully";

        return "Employee Not Found "+ name;
    }



    public String deleteEmployee(String name)
    {
        boolean isDeleted = false;

        for(int i = 0 ; i < employees.size() ; i++)
        {
            if(employees.get(i).getFirstName().equals(name) || employees.get(i).getLastName().equals(name))
            {
                employees.remove(i);
                isDeleted = true;
                break;
            }
        }

        if(isDeleted) return "Employee Deleted Successfully";

        return "Employee Not Found "+name;
    }
}
