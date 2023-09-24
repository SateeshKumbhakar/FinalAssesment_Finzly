package com.bbc.ops.BBCOps.service.payment;

import java.util.List;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.InvoiceNotFoundException;
import com.bbc.ops.BBCOps.exception.PaymetNotFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.model.Payment;

public interface PaymentService {

	List<Payment> getAllPayments();

	List<Payment> getCustomerAllPayments(int customerId) throws CustomerNotFoundException;

	Payment getPayment(int paymentId) throws PaymetNotFoundException;

	Object generatePayment(Customer customerDB, Bill billDB, Payment payment);

	Payment deletePayment(int paymentId) throws  PaymetNotFoundException;

	Payment updatePayment(int paymentId, Payment payment) throws PaymetNotFoundException;

}
