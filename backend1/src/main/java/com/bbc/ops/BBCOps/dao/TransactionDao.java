package com.bbc.ops.BBCOps.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bbc.ops.BBCOps.model.Transaction;

@Repository
public class TransactionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	// Get All Transaction
	
	public List<Transaction> getAllTranscation() {
		try (Session session = sessionFactory.openSession()) {

			Criteria criteria = session.createCriteria(Transaction.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}
	
	
	public Transaction getTransaction(int transactionId) {
		try (Session session = sessionFactory.openSession()) {

			return session.get(Transaction.class, transactionId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Transaction();
	}
	
	 
	/*Generate Transaction
	 */
	
	public Transaction generateTransaction(Transaction transaction) {
		
		Transaction transactionDB = null;
		try (Session session = sessionFactory.openSession()) {
			session.save(transaction);
			session.beginTransaction().commit();
			transactionDB = session.get(Transaction.class,transaction.getTransactionId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionDB;
	}


	public Transaction deleteTransaction(int transactionId) {
		
		Transaction transactionDB = null;
		try (Session session = sessionFactory.openSession()) {
			transactionDB = session.get(Transaction.class, transactionId);
			session.delete(transactionDB);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionDB;
	}

}
