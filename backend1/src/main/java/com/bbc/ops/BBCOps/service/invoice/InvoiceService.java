package com.bbc.ops.BBCOps.service.invoice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bbc.ops.BBCOps.exception.CustomerNotFoundException;
import com.bbc.ops.BBCOps.exception.InvoiceNotFoundException;
import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;

public interface InvoiceService {

	Invoice generateInvoice(Customer customerDB, Bill billDB);

	List<Invoice> getAllInvoices();

	List<Invoice> getCustomerAllInvoices(int customerId) throws CustomerNotFoundException;

	Invoice getInvoice(int invoiceId) throws InvoiceNotFoundException;

	Invoice deleteInvoice(int invoiceId) throws InvoiceNotFoundException;

}
