package com.bbc.ops.BBCOps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ops.BBCOps.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Employee getEmployee(int employeeId) {
		try (Session session = sessionFactory.openSession()) {

			return session.get(Employee.class, employeeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Employee();
		 
	}

}
