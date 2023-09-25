package com.bbc.ops.BBCOps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.InvoiceNotFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.service.bill.BillService;
import com.bbc.ops.BBCOps.service.customer.CustomerService;
import com.bbc.ops.BBCOps.service.invoice.InvoiceService;

@RestController
@RequestMapping("api")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	CustomerService customerService;
	@Autowired
	BillService billService;

	// Get All Invoices

	@GetMapping("/invoices")
	public ResponseEntity<Object> getAllInvoices() {
		List<Invoice> invoices = invoiceService.getAllInvoices();
		if (invoices.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Inovice is found.Thank you..!");
		} else {

			return ResponseEntity.ok().body(invoices);
		}
	}

	// Get All invoices for particular Customer
	@GetMapping("customer/{customerId}/invoices")
	public ResponseEntity<Object> getCustomerAllInvoices(@PathVariable int customerId) {
		try {
			List<Invoice> customerInvoices = invoiceService.getCustomerAllInvoices(customerId);

			if (customerInvoices.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(" No Inovice is found for given customer.Thank you..!");
			} else {
				return ResponseEntity.ok().body(customerInvoices);
			}

		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Inovice is found for given customer.Thank you..!");
	}

	// Get Invoice By Its ID
	@GetMapping("/invoices/{invoiceId}")
	public ResponseEntity<Object> getInvoice(@PathVariable int invoiceId) {
		
		try {
			Invoice invoice = invoiceService.getInvoice(invoiceId);
			return ResponseEntity.status(HttpStatus.FOUND).body(invoice);
		} catch (InvoiceNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Inovice is found for given InoviceID.Thank you..!");
	}

	
	// Generate Invoice For a customer for Bill
	@PostMapping("customer/{customerId}/{billId}/invoice")
	public ResponseEntity<Object> generateInvoice(@PathVariable int customerId, @PathVariable int billId) {
		try {
			Customer customerDB = customerService.getCustomer(customerId);

			if (customerDB != null) {
				Bill billDB = billService.getCustomerBill(customerDB.getCustomerId(), billId);
				if (billDB != null) {

					return ResponseEntity.ok(invoiceService.generateInvoice(customerDB, billDB));
				}
			}

		} catch (Exception e) {

		}

		return ResponseEntity.badRequest().body("Invoice is not generated");
	}

	// Delete Invoice
	@DeleteMapping("/invoices/{invoiceId}")
	public ResponseEntity<Object> deleteInvoice(@PathVariable int invoiceId) {
		
		try {
			Invoice invoice = invoiceService.deleteInvoice(invoiceId);
			
			return ResponseEntity.status(HttpStatus.FOUND).body(invoice);
		} catch (InvoiceNotFoundException e) {

			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Inovice is found for given InoviceID. Thank you..!");	
     
	}

}
