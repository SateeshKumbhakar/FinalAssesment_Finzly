package com.bbc.ops.BBCOps.exception;

public class MyException extends Exception {
	public MyException() {}
	
	public MyException(String msg) {
		super(msg);
	}

	public static CustomerNotFoundException  getCustomerNotFoundException() throws CustomerNotFoundException  {
		throw new CustomerNotFoundException ("Customer is not availble in Database");
	}
	public static BillNoFoundException  getBillNotFoundException() throws BillNoFoundException  {
		throw new BillNoFoundException("Bill is not availble in Database");
	}
	public static InvoiceNotFoundException  getInvoiceNotFoundException() throws InvoiceNotFoundException {
		throw new InvoiceNotFoundException("Invoice is not availble in Database");
	}
	
	public static TransactionNotFoundException  getTransactionNotFoundException() throws TransactionNotFoundException {
		throw new TransactionNotFoundException(" Transaction is not availble in Database");
	}
	public static PaymetNotFoundException  getPaymetNotFoundException() throws PaymetNotFoundException {
		throw new PaymetNotFoundException(" Payment is not availble in Database");
	}
	public static EmployeeNotFoundException  getEmployeeNotFoundException() throws EmployeeNotFoundException {
		throw new EmployeeNotFoundException(" Employee is not availble in Database");
	}
	public static BadCredentialsException  getBadCredentialsException() throws BadCredentialsException {
		throw new BadCredentialsException();
	}
	
}
