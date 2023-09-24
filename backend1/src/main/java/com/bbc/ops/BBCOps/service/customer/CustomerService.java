package com.bbc.ops.BBCOps.service.customer;

import java.util.List;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();

	Customer getCustomer(int customerId) throws CustomerNotFoundException;

	Customer addCustomer(Customer customer);

	Object updateCustomer(int customerId, Customer customer) throws CustomerNotFoundException;

	
}
