package com.bbc.ops.BBCOps.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ops.BBCOps.exception.EmployeeNotFoundException;

import com.bbc.ops.BBCOps.model.Employee;
import com.bbc.ops.BBCOps.service.employee.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/auth")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("login")
	public ResponseEntity<Object> login(@RequestBody Employee loginData) {
		try {
			int employeeId = loginData.getEmployeeId();
			String password = loginData.getPassword().trim();
			 
			Employee employeeDB = employeeService.getEmployee(employeeId);
						 
			if(employeeId == employeeDB.getEmployeeId() &&  password.equals(employeeDB.getPassword())) {
				String token = employeeService.login(employeeDB);
				Map< String,String> mp = new HashMap<>();
				mp.put("token", token);
				
				return ResponseEntity.ok(mp);
			}
			else {
				Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("errorMsg", "Invalid Credential");
	            return ResponseEntity.ok(errorResponse);
			}
		} catch (EmployeeNotFoundException e) {
			  Map<String, String> errorResponse = new HashMap<>();
		      errorResponse.put("errorMsg", "Employee Not Found");
	          return ResponseEntity.ok(errorResponse);
		}

	}
	
	// Get One Employee
	@GetMapping("getEmployee/{employeeId}")

	public ResponseEntity<?> getEmployee(@PathVariable int employeeId) throws EmployeeNotFoundException {

		Employee employeeDB = null;
		try {
			employeeDB = employeeService.getEmployee(employeeId);

			return ResponseEntity.ok(employeeDB);

		} catch (EmployeeNotFoundException e) {

			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee Found with this " + employeeId);

	}

}
