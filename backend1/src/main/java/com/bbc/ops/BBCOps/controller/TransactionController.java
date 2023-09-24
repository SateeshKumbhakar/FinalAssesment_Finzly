package com.bbc.ops.BBCOps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.PaymetNotFoundException;
import com.bbc.ops.BBCOps.exception.TransactionNotFoundException;
 
import com.bbc.ops.BBCOps.model.Payment;
import com.bbc.ops.BBCOps.model.Transaction;
import com.bbc.ops.BBCOps.service.payment.PaymentService;
import com.bbc.ops.BBCOps.service.transaction.TransactionService;

@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	@Autowired
	PaymentService paymentService;

	// API 1
	// Get All Transaction
	@GetMapping("transactions")
	public ResponseEntity<Object> getAllTranscation() {
		List<Transaction> transactions = transactionService.getAllTranscation();

		if (transactions.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Transaction is found.Thank you..!");
		} else {

			return ResponseEntity.ok().body(transactions);
		}
	}

/*  // API 2
	// Get All transactions for particular customer
	@GetMapping("customer/payments/{paymentId}/transactions")
	public ResponseEntity<Object> getCustomerAllPayments(@PathVariable int customerId) {
		try {
			List<Transaction> customerTransactions = transactionService.getCustomerAllTransactions(customerId);

			if (customerTransactions.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(" No Transaction is found for given customer.Thank you..!");
			} else {
				return ResponseEntity.ok().body(customerTransactions);
			}

		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Transaction is found for given customer.Thank you..!");
	}
*/
	
	// API 3
	// Get Transaction By Its ID
	@GetMapping("/transactions/{transactionId}")
	public ResponseEntity<Object> getTransaction(@PathVariable int transactionId) {

		try {
			Transaction transactionDB = transactionService.getTransaction(transactionId);
			return ResponseEntity.status(HttpStatus.FOUND).body(transactionDB);
		} catch (TransactionNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(" No Transaction is found for given Transaction Id.Thank you..!");
	}

	// API 4
	// Generate Transactions For a given Payment
	@PostMapping("customer/payment/{paymentId}/transaction")
	public ResponseEntity<Object> generateTransaction(@PathVariable int paymentId) {
		try {

			Payment paymentDB = paymentService.getPayment(paymentId);
			
			if (paymentDB != null) {
				Transaction transactionDB = transactionService.generateTransaction(paymentDB);
				return ResponseEntity.ok(transactionDB);
			}
		} catch (PaymetNotFoundException e) {

		}

		return ResponseEntity.badRequest().body("Transaction is not created..");
	}
	
	// API 6
	// Delete Transaction
		@DeleteMapping("/transactions/{transactionId}")
		public ResponseEntity<Object> deleteTransaction(@PathVariable int transactionId) throws TransactionNotFoundException {

			try {
				Transaction transactionDB = transactionService.getTransaction(transactionId);
				
				if(transactionDB != null) {
					return ResponseEntity.status(HttpStatus.FOUND).body(transactionService.deleteTransaction(transactionId));
				}

				
			} catch (TransactionNotFoundException e) {

				e.printStackTrace();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(" No Transaction is found for given for given customer. Thank you..!");

		}
}
