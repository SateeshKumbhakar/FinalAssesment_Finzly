package com.bbc.ops.BBCOps.service.employee;

import com.bbc.ops.BBCOps.exception.EmployeeNotFoundException;
import com.bbc.ops.BBCOps.model.Employee;

public interface EmployeeService {

	

	Employee getEmployee(int employeeId) throws EmployeeNotFoundException;

	String login(Employee employeeDB);

}
