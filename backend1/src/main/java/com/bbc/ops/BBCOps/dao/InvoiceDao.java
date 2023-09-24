package com.bbc.ops.BBCOps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ops.BBCOps.model.Customer;
import com.bbc.ops.BBCOps.model.Invoice;

@Repository
public class InvoiceDao {

	@Autowired
	SessionFactory sessionFactory;

	public Invoice generateInvoice(Invoice invoice) {

		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(invoice);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return invoice;
	}

	// Get All Invoices 
	public List<Invoice> getAllInvoices() {
		try (Session session = sessionFactory.openSession()) {

			Criteria criteria = session.createCriteria(Invoice.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	// Get All invoice of a Customer
	public List<Invoice> getCustomerAllInvoices(Customer customerDB) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Invoice.class);
			criteria.add(Restrictions.eq("customer", customerDB));
			return criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	public Invoice getInvoice(int invoiceId) {
		try (Session session = sessionFactory.openSession()) {

			return session.get(Invoice.class, invoiceId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Invoice();
	}

	// Update Invoice

	// Delete invoice
	public Invoice deleteInvoice(int invoiceId) {
		Invoice invoiceDB = null;
		try (Session session = sessionFactory.openSession()) {
			invoiceDB = session.get(Invoice.class, invoiceId);
			session.delete(invoiceDB);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoiceDB;
	}

}
