package com.bbc.ops.BBCOps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ops.BBCOps.model.Customer;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	BillDao billDao;

	// Get all customer
	public List<Customer> getAllCustomer() {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();

	}

	// Get Customer
	public Customer getCustomer(int customerId) {
		Customer customerDB = null;

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();

			customerDB = session.get(Customer.class, customerId);
			if (customerDB == null) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDB;

	}

	// Add User
	public Customer addCustomer(Customer customer) {

		Session session = sessionFactory.openSession();
		session.save(customer);
		session.beginTransaction().commit();
		session.close();

		return customer;

	}

	// update Customer
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer customerDB = null;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();

			customerDB = session.get(Customer.class, customerId);

			customerDB.setCustomerName(customer.getCustomerName());
			customerDB.setPassword(customer.getPassword());
			customerDB.setOTP(customer.getOTP());
			customerDB.setCustomerAadharcardno(customer.getCustomerAadharcardno());
			customerDB.setContactInfo(customer.getContactInfo());
			customerDB.setAddress(customer.getAddress());
//			customerDB.setBill(customer.getBill());

			session.update(customerDB);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerDB;
	}

}
