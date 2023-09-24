package com.bbc.ops.BBCOps.service.bill;

import java.util.List;

import com.bbc.ops.BBCOps.exception.BillNoFoundException;
import com.bbc.ops.BBCOps.model.Bill;

public interface BillService {

	List<Bill> getAllBills();

	List<Bill> getCustomerAllBills(int customerId) throws BillNoFoundException;

	Bill getCustomerBill(int customerId, int billId) throws BillNoFoundException;

	Bill addCustomerBill(int customerId, Bill bill);

	Bill updateCustomerBill(int customerId, int billId, Bill bill);

	Bill deleteCustomerBill(int customerId, int billId);

}
