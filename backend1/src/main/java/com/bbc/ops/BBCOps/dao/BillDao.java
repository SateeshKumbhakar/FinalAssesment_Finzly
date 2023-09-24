package com.bbc.ops.BBCOps.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ops.BBCOps.model.Bill;
import com.bbc.ops.BBCOps.model.Customer;

@Repository
public class BillDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Bill> getAllBills() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		return criteria.list();
	}

	public List<Bill> getCustomerAllBills(Customer customer) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Bill.class);

		criteria.add(Restrictions.eq("customerId", customer.getCustomerId()));

		return criteria.list();
	}

	public Bill getCustomerBill(Customer customer, int billId) {
        
//		return getCustomerAllBills(customer) ;
		Session session = sessionFactory.openSession();
		return session.get(Bill.class, billId);
	}

	public Bill addCustomerBill(Customer customerDB, Bill bill) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(bill);
			tx.commit();
			
//			customerDB.getBill().add(bill);
//		    bill.setCustomer(customerDB);			
//            session.update(customerDB);
			

		} catch (Exception e) {

		}

		return bill;
	}

	public Bill updateCustomerBill(int billId, Bill bill) {
		Bill billDB = null;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();

			billDB = session.get(Bill.class, billId);
			billDB.setBillDueDate(bill.getBillDueDate());
			billDB.setBillDuration(bill.getBillDuration());
			billDB.setUnitConsumption(bill.getUnitConsumption());
			billDB.setPaid(bill.getPaid());

			session.update(billDB);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return billDB;
	}

	public Bill deleteCustomerBill(int billId) {

		try (Session session = sessionFactory.openSession()) {

			Transaction tx = session.beginTransaction();

			Bill billDB = session.get(Bill.class, billId);
			session.delete(billDB);

			tx.commit();
			return billDB;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
