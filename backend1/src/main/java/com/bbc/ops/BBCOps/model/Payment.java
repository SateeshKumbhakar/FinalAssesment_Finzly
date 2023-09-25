package com.bbc.ops.BBCOps.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private String paymentMode;
	private String paymentMethod;
	private String paymentStatus;
	private double amount;
	
	@Column(unique = true)
	private String referenceNo=UUID.randomUUID().toString();;

	@ManyToOne()
	@JoinColumn(name = "customer_id_f")
	private Customer customer;

	@ManyToOne()
	@JoinColumn(name = "bill_id_f")
	private Bill bill;

	public Payment() {

	}
	public Payment(int paymentId, String paymentMode, String paymentMethod,
			Customer customer, Bill bill,String referenceNo,String paymentStatus,double amount) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		this.bill = bill;
		this.referenceNo = referenceNo;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
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
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentMethod=" + paymentMethod
				+ ", paymentStatus=" + paymentStatus + ", referenceNo=" + referenceNo + ", customer=" + customer
				+ ", bill=" + bill + "]";
	}

	

}
