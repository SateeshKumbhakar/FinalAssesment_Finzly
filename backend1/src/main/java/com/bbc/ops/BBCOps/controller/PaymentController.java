package com.bbc.ops.BBCOps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.InvoiceNotFoundException;
import com.bbc.ops.BBCOps.exception.PaymetNotFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.model.Payment;
import com.bbc.ops.BBCOps.service.bill.BillService;
import com.bbc.ops.BBCOps.service.customer.CustomerService;
import com.bbc.ops.BBCOps.service.payment.PaymentService;

@RestController
@RequestMapping("api")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BillService billService;

	// API 1
	// Get All Payments
	@GetMapping("payments")
	public ResponseEntity<Object> getAllBills() {
		List<Payment> payments = paymentService.getAllPayments();

		if (payments.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Payment is found.Thank you..!");
		} else {

			return ResponseEntity.ok().body(payments);
		}
	}

	// API 2
	// Get All Payments for particular Customer
	@GetMapping("customer/{customerId}/payments")
	public ResponseEntity<Object> getCustomerAllPayments(@PathVariable int customerId) {
		try {
			List<Payment> customerPayments = paymentService.getCustomerAllPayments(customerId);

			if (customerPayments.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(" No Payment is found for given customer.Thank you..!");
			} else {
				return ResponseEntity.ok().body(customerPayments);
			}

		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Payments is found for given customer.Thank you..!");
	}
/*
	// API 3
	// Get Payment of customer on the basis of billId
	@GetMapping
	public ResponseEntity<Object> getCustomerAllPaymentsForBill(@PathVariable int customerId,@PathVariable int billId) {
	}
*/	
	
	
	
	// API 4
	// Get Payment By Its ID
	@GetMapping("/payments/{paymentId}")
	public ResponseEntity<Object> getPayment(@PathVariable int paymentId) {

		try {
			Payment paymentDB = paymentService.getPayment(paymentId);
			return ResponseEntity.status(HttpStatus.FOUND).body(paymentDB);
		} catch (PaymetNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Payment is found for given Payment ID.Thank you..!");
	}
	
	

	// API 5
	// Generate Payments For a customer for Bill
	@PostMapping("customer/{customerId}/{billId}/payment")
	public ResponseEntity<Object> generatePayment(@PathVariable int customerId, @PathVariable int billId,
			@RequestBody Payment payment) {
		try {
			Customer customerDB = customerService.getCustomer(customerId);

			if (customerDB != null) {
				Bill billDB = billService.getCustomerBill(customerDB.getCustomerId(), billId);
				if (billDB != null) {

					return ResponseEntity.ok(paymentService.generatePayment(customerDB, billDB, payment));
				}
			}

		} catch (Exception e) {

		}

		return ResponseEntity.badRequest().body("Payment is not created..");
	}

	// API 6
	// Update Payment
	@PutMapping("/payments/{paymentId}")
	public ResponseEntity<Object> updatePayment(@PathVariable int paymentId, @RequestBody Payment payment)
			throws PaymetNotFoundException {

		try {
			Payment paymentDB = paymentService.updatePayment(paymentId, payment);

			return ResponseEntity.status(HttpStatus.FOUND).body(paymentDB);
		} catch (PaymetNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Payment is found for given for given customer. Thank you..!");

	}

	// API 7
	// Delete Payment
	@DeleteMapping("/payments/{paymentId}")
	public ResponseEntity<Object> deletePayment(@PathVariable int paymentId) throws PaymetNotFoundException {

		try {
			Payment paymentDB = paymentService.deletePayment(paymentId);

			return ResponseEntity.status(HttpStatus.FOUND).body(paymentDB);
		} catch (PaymetNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Payment is found for given for given customer. Thank you..!");

	}

}
