package com.bbc.ops.BBCOps.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.BillDao;
import com.bbc.ops.BBCOps.dao.CustomerDao;
import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	BillDao billDao;

	@Override
	public List<Customer> getAllCustomer() {

		return customerDao.getAllCustomer();
	}

	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException    {

		Customer customerDB = customerDao.getCustomer(customerId);
		if (customerDB == null) {
			throw MyException.getCustomerNotFoundException();
		}
		return customerDB;

	}

	@Override
	public Customer addCustomer(Customer customer) {
	   //logic for validation
		
	return customerDao.addCustomer(customer) ;
	}

	
	@Override
	public Object updateCustomer(int customerId, Customer customer) throws CustomerNotFoundException {
		Customer customerDB = customerDao.getCustomer(customerId);
		if (customerDB == null) {
			throw MyException.getCustomerNotFoundException();
		}
		return customerDao.updateCustomer(customerId,customer);
	}

}
