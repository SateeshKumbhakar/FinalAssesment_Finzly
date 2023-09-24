package com.bbc.ops.BBCOps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;
import com.bbc.ops.BBCOps.model.Payment;

@Repository
public class PaymentDao {

	@Autowired
	SessionFactory sessionFactory;

	// Get All list of payments
	public List<Payment> getAllPayments() {
		try (Session session = sessionFactory.openSession()) {
			
			Criteria criteria = session.createCriteria(Payment.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	// Get Customer All Payments
	public List<Payment> getCustomerAllPayments(Customer customerDB) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Payment.class);
			criteria.add(Restrictions.eq("customer", customerDB));
			return criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	// Get Payment By PaymentId
	public Payment getPayment(int paymentId) {

		try (Session session = sessionFactory.openSession()) {

			return session.get(Payment.class, paymentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Payment();

	}

	// Create Payments
	public Payment generatePayment(Payment payment) {
		Payment paymentDB = null;
		try (Session session = sessionFactory.openSession()) {
			session.save(payment);
			session.beginTransaction().commit();
			paymentDB = session.get(Payment.class,payment.getPaymentId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentDB;
	}
	
	public Payment updatePayment(int paymentId, Payment payment) {
		Payment paymentDB = null;
		try (Session session = sessionFactory.openSession()) {
			session.update(payment);
			session.beginTransaction().commit();
			paymentDB = session.get(Payment.class, paymentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentDB;
		
	}
   
	//Delete Payment
	public Payment deletePayment(int paymentId) {
		Payment paymentDB = null;
		try (Session session = sessionFactory.openSession()) {
			paymentDB = session.get(Payment.class, paymentId);
			session.delete(paymentDB);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentDB;
	}


}
