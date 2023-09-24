package com.bbc.ops.BBCOps.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String paymentMode;
	private String paymentStatus;
	private double amount;
	
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	public Transaction() {
	}

	public Transaction(int transactionId ,String paymentMode, String paymentStatus,
			 double amount) {
		super();
		this.transactionId = transactionId;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", paymentMode=" + paymentMode + ", paymentStatus="
				+ paymentStatus + ", amount=" + amount + ", payment=" + payment + "]";
	}

	


}
