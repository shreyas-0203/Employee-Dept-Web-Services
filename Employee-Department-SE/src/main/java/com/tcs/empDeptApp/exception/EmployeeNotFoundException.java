package com.tcs.empDeptApp.exception;

/**
 * @author Simpson Alfred
 */

public class EmployeeNotFoundException extends RuntimeException
{
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }
}
