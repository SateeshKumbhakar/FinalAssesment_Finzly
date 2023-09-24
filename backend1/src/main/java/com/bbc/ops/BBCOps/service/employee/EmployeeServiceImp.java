package com.bbc.ops.BBCOps.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.EmployeeDao;
import com.bbc.ops.BBCOps.exception.EmployeeNotFoundException;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.model.Employee;
import com.bbc.ops.BBCOps.security.MySecurity;

@Service
public class EmployeeServiceImp implements EmployeeService {

	
	@Autowired
	EmployeeDao employeeDao;
//	MySecurity mySecurity;
	
	@Override
	public Employee getEmployee(int employeeId) throws EmployeeNotFoundException  {
		Employee employeeDB = employeeDao.getEmployee(employeeId);
		if(employeeDB ==null) {
			throw MyException.getEmployeeNotFoundException();
		}
		return employeeDB;
	}

	@Override
	public String login(Employee employeeDB) {
		MySecurity mySecurity = new MySecurity();
		return  mySecurity.generateToken(employeeDB) ;
	}

}
