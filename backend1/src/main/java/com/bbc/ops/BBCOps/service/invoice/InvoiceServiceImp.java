package com.bbc.ops.BBCOps.service.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.CustomerDao;
import com.bbc.ops.BBCOps.dao.InvoiceDao;
import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.InvoiceNotFoundException;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.service.customer.CustomerService;

@Service
public class InvoiceServiceImp implements InvoiceService {
	@Autowired
	InvoiceDao invoiceDao;
	@Autowired 
	CustomerService customerService;


	@Override
	public Invoice generateInvoice(Customer customerDB, Bill billDB) {
		
		Invoice invoice = new Invoice();
		invoice.setBill(billDB);	 
		invoice.setCustomer(customerDB);
		
		invoice.setBillDueDate(billDB.getBillDueDate());
		invoice.setPaymentStatus(billDB.getPaid());
		double amount = 41.50* billDB.getUnitConsumption();
		double earlyPayment =  amount - amount*0.5;
		double onlinePayment = amount - amount*0.5;
		invoice.setAmount(amount);
		invoice.setEarlyPayment(earlyPayment);
		invoice.setOnlinePayment(onlinePayment);
		invoice.setTotalAmount(amount);
		 
		return invoiceDao.generateInvoice(invoice);
	}


	@Override
	public List<Invoice> getAllInvoices() {	
		return invoiceDao.getAllInvoices();
	}


	@Override
	public List<Invoice> getCustomerAllInvoices(int customerId) throws CustomerNotFoundException {
		 Customer customerDB = customerService.getCustomer(customerId);
		return invoiceDao.getCustomerAllInvoices(customerDB);
	}


	@Override
	public Invoice getInvoice(int invoiceId) throws InvoiceNotFoundException {
		 Invoice invoice = invoiceDao.getInvoice(invoiceId);
		 if(invoice == null) {
			 throw MyException.getInvoiceNotFoundException();
		 }
		return invoice;
	}


	@Override
	public Invoice deleteInvoice(int invoiceId) throws InvoiceNotFoundException {
		 Invoice invoice = invoiceDao.getInvoice(invoiceId);
		 if(invoice == null) {
			 throw MyException.getInvoiceNotFoundException();
		 }
		return invoiceDao.deleteInvoice(invoiceId);
	}

}
