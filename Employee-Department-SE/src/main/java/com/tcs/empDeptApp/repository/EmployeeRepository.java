package com.tcs.empDeptApp.repository;

import com.tcs.empDeptApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    Optional<Employee> findByEmail(String email);
}
