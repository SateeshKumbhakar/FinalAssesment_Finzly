package com.bbc.ops.BBCOps.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.PaymentDao;
import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.exception.PaymetNotFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.model.Payment;
import com.bbc.ops.BBCOps.service.customer.CustomerService;

@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired
	PaymentDao paymentDao;
	@Autowired
	CustomerService customerService;

	@Override
	public List<Payment> getAllPayments() {
		return paymentDao.getAllPayments();
	}

	@Override
	public List<Payment> getCustomerAllPayments(int customerId) throws CustomerNotFoundException {
		
		Customer customerDB = customerService.getCustomer(customerId);
		
		return paymentDao.getCustomerAllPayments(customerDB);

	}

	@Override
	public Payment getPayment(int paymentId) throws PaymetNotFoundException {
		Payment payment = paymentDao.getPayment(paymentId);
		if (payment == null) {
			throw MyException.getPaymetNotFoundException();
		}
		return payment;

	}

	@Override
	public Payment generatePayment(Customer customerDB, Bill billDB,Payment payment) {
		
		// Adding Customer and Bill details 
		payment.setCustomer(customerDB);
		payment.setBill(billDB);
		return paymentDao.generatePayment(payment);
	}

	@Override
	public Payment updatePayment(int paymentId ,Payment payment) throws PaymetNotFoundException{
		Payment paymentDB = paymentDao.getPayment(paymentId);
		// if payment is found then go for update
		
		//update status which is coming from Body
		paymentDB.setPaymentStatus(payment.getPaymentStatus());
		// Also update bill status which is coming from Body
	    paymentDB.getBill().setPaid(payment.getBill().getPaid());
	
		return  paymentDao.updatePayment(paymentId,paymentDB);
	}
	
	@Override
	public Payment deletePayment(int paymentId) throws  PaymetNotFoundException{
		Payment payment = paymentDao.getPayment(paymentId);
		 if(payment == null) {
			 throw MyException.getPaymetNotFoundException();
		 }
		return paymentDao.deletePayment(paymentId);
	}


}
