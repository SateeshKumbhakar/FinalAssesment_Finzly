package com.bbc.ops.BBCOps.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private Date billDueDate;
	private double unitConsumption;
	private String billDuration;
	private boolean paid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;
	  
	@ManyToOne( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id_f")
	private Customer customer;
	
	private int customerId;

	public Bill() {

	}

	public Bill( Date billDueDate, double unitConsumption, String billDuration,
			boolean paid,int id) {
		super();
		this.billDueDate = billDueDate;
		this.unitConsumption = unitConsumption;
		
		this.billDuration = billDuration;
		this.paid = paid;
		this.customerId =id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean getPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid =paid;
	}

	public int  getBillId () {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getUnitConsumption() {
		return unitConsumption;
	}

	public void setUnitConsumption(double unitConsumption) {
		this.unitConsumption = unitConsumption;
	}

	public String getBillDuration() {
		return billDuration;
	}

	public void setBillDuration(String billDuration) {
		this.billDuration = billDuration;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

}
