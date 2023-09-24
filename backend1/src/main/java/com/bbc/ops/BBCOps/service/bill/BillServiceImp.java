package com.bbc.ops.BBCOps.service.bill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.BillDao;
import com.bbc.ops.BBCOps.dao.CustomerDao;
import com.bbc.ops.BBCOps.exception.BillNoFoundException;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;

@Service
public class BillServiceImp implements BillService {

	@Autowired
	BillDao billDao;
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Bill> getAllBills() {

		return billDao.getAllBills();
	}

	@Override
	public List<Bill> getCustomerAllBills(int customerId) throws BillNoFoundException {

		Customer customer = customerDao.getCustomer(customerId);
		if (customer == null) {
			throw MyException.getBillNotFoundException();
		}

		return billDao.getCustomerAllBills(customer);
	}

	@Override
	public Bill getCustomerBill(int customerId, int billId) throws BillNoFoundException {
		Customer customerDB = customerDao.getCustomer(customerId);

		if (customerDB == null) {
			throw MyException.getBillNotFoundException();
		}

		return  billDao.getCustomerBill(customerDB, billId);
	}

	@Override
	public Bill addCustomerBill(int customerId, Bill bill) {
		Customer customerDB = customerDao.getCustomer(customerId);

		if (customerDB == null) {
			return null;
		}

		bill.setCustomerId(customerId);
		return billDao.addCustomerBill(customerDB, bill);
	}

	@Override
	public Bill updateCustomerBill(int customerId,int  billId, Bill bill ) {
		Customer customerDB = customerDao.getCustomer(customerId);

		if (customerDB == null) {
			return null;
		}
		
		return  billDao.updateCustomerBill(billId,bill);
	}

	@Override
	public Bill deleteCustomerBill(int customerId, int billId) {
		Customer customerDB = customerDao.getCustomer(customerId);

		if (customerDB == null) {
			return null;
		}
		return billDao.deleteCustomerBill(billId);
	}

}
