package com.bbc.ops.BBCOps.service.transaction;

import java.util.List;

import com.bbc.ops.BBCOps.exception.TransactionNotFoundException;
import com.bbc.ops.BBCOps.model.Payment;
import com.bbc.ops.BBCOps.model.Transaction;

public interface TransactionService {

	List<Transaction> getAllTranscation();

//	List<Transaction> getCustomerAllTransactions(int customerId);

	Transaction getTransaction(int transactionId) throws TransactionNotFoundException;

	Transaction generateTransaction(Payment paymentDB);

	Transaction deleteTransaction(int transactionId) throws TransactionNotFoundException;

}
