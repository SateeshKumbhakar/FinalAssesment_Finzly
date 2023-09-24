package com.bbc.ops.BBCOps.controller;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.model.Address;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.ContactInfo;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.service.bill.BillService;
import com.bbc.ops.BBCOps.service.customer.CustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	BillService billService;

	// Get All Customer
	@GetMapping("get-all")
	public ResponseEntity<Object> getAllCustomer() {
		List<Customer> customers = customerService.getAllCustomer();

		if (customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" No Customer is found.Thank you..!");
		} else {

			return ResponseEntity.ok().body(customers);
		}
	}

//	
	// Get One Customer
	@GetMapping("get-customer/{customerId}")
	public ResponseEntity<Object> getCustomer(@PathVariable int customerId) {

		Customer customer = null;
		try {
			customer = customerService.getCustomer(customerId);

			return ResponseEntity.ok(customer);

		} catch (CustomerNotFoundException e) {

			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Customer Found with this " + customerId);

	}

	// Add One Customer
	@PostMapping("add-customer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.addCustomer(customer));
	}

	// Add Customer in Bulk
	@PostMapping("add-customer-in-bulk")
	public ResponseEntity<Object> addCustomerInBulk(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("Please select a CSV file to upload.");
		}

		try (Reader reader = new InputStreamReader(file.getInputStream());
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

			for (CSVRecord csvRecord : csvParser) {

				// Perform data validation here
				int customerId = Integer.parseInt(csvRecord.get("customerId"));
				String customerName = csvRecord.get("customerName");
				String password = csvRecord.get("password");
				String customerAadharcardno = csvRecord.get("customerAadharcardno");
				String otp = csvRecord.get("otp");
				String billDuration = csvRecord.get("billDuration");
				Date billDueDate = dateFormat.parse(csvRecord.get("billDueDate"));
				double unitConsumption = Double.parseDouble(csvRecord.get("unitConsumption"));
				boolean isPaid = Boolean.parseBoolean(csvRecord.get("isPaid"));
				String street = csvRecord.get("street");
				String city = csvRecord.get("city");
				String state = csvRecord.get("state");
				String postalCode = csvRecord.get("postalCode");
				String phone = csvRecord.get("phone");
				String email = csvRecord.get("email");

				Address address = new Address(street, city, state, postalCode);
				ContactInfo contactInfo = new ContactInfo(phone, email);

				Customer customer = new Customer(customerId, customerName, password, customerAadharcardno, address,
						contactInfo, otp, new ArrayList<>());
				Bill bill = new Bill(billDueDate, unitConsumption, billDuration, isPaid, customerId);

				// Add Customer and bill;
				Customer customerDB = customerService.addCustomer(customer);
				billService.addCustomerBill(customerDB.getCustomerId(), bill);

			}

			return ResponseEntity.ok("CSV data uploaded successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred while processing the CSV file.");
		}
	}


 	//Update One Customer
 	@PutMapping ("update-customer/{customerId}")
 	public ResponseEntity<Object> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){
 		try {
			return ResponseEntity.ok(customerService.updateCustomer(customerId,customer));
		} catch (CustomerNotFoundException e) {
			
			e.printStackTrace();
		}
 		return ResponseEntity.badRequest().body("Customer is not updated..");
 	}
	
// 	//Delete One Customer
// 	@PutMapping ("delete-customer/{customerId}")
// 	public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId){
// 		
// 	}

}
