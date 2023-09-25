package com.bbc.ops.BBCOps.service.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ops.BBCOps.dao.PaymentDao;
import com.bbc.ops.BBCOps.dao.TransactionDao;
import com.bbc.ops.BBCOps.exception.MyException;
import com.bbc.ops.BBCOps.exception.TransactionNotFoundException;
import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Payment;
import com.bbc.ops.BBCOps.model.Transaction;
import com.bbc.ops.BBCOps.service.customer.CustomerService;

@Service
public class TransactionServiceImp implements TransactionService {
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	CustomerService customerService;

	@Override
	public List<Transaction> getAllTranscation() {

		return transactionDao.getAllTranscation();
	}
/*
	@Override
	public List<Transaction> getCustomerAllTransactions(int customerId) {
		Customer customerDB = customerService.getCustomer(customerId);

		return transactionDao.getCustomerAllTransactions(customerDB);
	}
*/
	@Override
	public Transaction getTransaction(int transactionId) throws TransactionNotFoundException {
		Transaction transaction = transactionDao.getTransaction(transactionId);
		if (transaction == null) {
			throw MyException.getTransactionNotFoundException();
		}
		return transaction;
	}

	@Override
	public Transaction generateTransaction(Payment paymentDB) {
		 Transaction transaction = new Transaction();
		 transaction.setPaymentMode(paymentDB.getPaymentMode());
		 transaction.setPaymentStatus(paymentDB.getPaymentStatus());
		 transaction.setPayment(paymentDB);
		 transaction.setAmount(paymentDB.getAmount());
		return transactionDao.generateTransaction(transaction);
	}

	@Override
	public Transaction deleteTransaction(int transactionId) throws TransactionNotFoundException {
		Transaction transaction = transactionDao.getTransaction(transactionId);
		 if(transaction == null) {
			 throw MyException.getTransactionNotFoundException();
		 }
		return transactionDao.deleteTransaction(transactionId);
	}

}
