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

import com.bbc.ops.BBCOps.exception.BillNoFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.service.bill.BillService;

@RestController
@RequestMapping("api")
public class BillController {

	@Autowired
	BillService billService;

	@GetMapping("all-bill")
	public ResponseEntity<Object> getAllBills() {
		List<Bill> bills = billService.getAllBills();

		if (bills.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Bill is found.Thank you..!");
		} else {

			return ResponseEntity.ok().body(bills);
		}
	}
	
	@GetMapping("customer/{customerId}/all-bill")
	public ResponseEntity<Object> getCustomerAllBills(@PathVariable int customerId) {
		try {
			List<Bill> customerBills = billService.getCustomerAllBills(customerId);
			if (customerBills.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Bill is found.Thank you..!");
			} else {
				return ResponseEntity.ok().body(customerBills);
			}
		} catch (BillNoFoundException e) {
			
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Bill is found.Thank you..!");
		
	}
	
	@GetMapping("customer/{customerId}/bill/{billId}")
	public ResponseEntity<Object> getCustomerBill(@PathVariable int customerId,@PathVariable int billId) throws BillNoFoundException {
		
		Bill customerBill= billService.getCustomerBill(customerId,billId);
		
		if (customerBill== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Bill is found for cusotmer.Thank you..!");
		} else {
			return ResponseEntity.ok().body(customerBill);
		}
	}
	
	// Add customer bill
	@PostMapping("customer/{customerId}/bill")
	public ResponseEntity<Object> addCustomerBill(@PathVariable int customerId, @RequestBody Bill bill) {
		
		Bill customerBill = billService.addCustomerBill(customerId,bill);
		
		if (customerBill== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Bill is not Added. Try agian,Thank you..!");
		} else {
			return ResponseEntity.ok().body(customerBill);
		}
	}
	
	
	// Update customer bill
	@PutMapping("customer/{customerId}/bill/{billId}")
	public ResponseEntity<Object> updateCustomerBill(@PathVariable int customerId, @PathVariable int billId, @RequestBody Bill bill) {
		
		Bill customerBill = billService.updateCustomerBill(customerId,billId, bill);
		
		if (customerBill== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Bill is not updated. Try agian,Thank you..!");
		} else {
			return ResponseEntity.ok().body(customerBill);
		}
	}
	
	// Update customer bill
	@DeleteMapping("customer/{customerId}/bill/{billId}")
	public ResponseEntity<Object> deleteCustomerBill(@PathVariable int customerId, @PathVariable int billId) {
		
		Bill customerBill = billService.deleteCustomerBill(customerId,billId);
		
		if (customerBill== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("  Customer or bill  is not Found. Try agian,Thank you..!");
		} else {
			return ResponseEntity.ok().body(customerBill);
		}
	}
	
	

}
