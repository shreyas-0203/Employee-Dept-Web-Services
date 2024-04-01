package com.tcs.empDeptApp.exception;

/**
 * @author Simpson Alfred
 */

public class EmployeeAlreadyExistsException extends RuntimeException
{
    public EmployeeAlreadyExistsException(String message)
    {
        super(message);
    }
}
