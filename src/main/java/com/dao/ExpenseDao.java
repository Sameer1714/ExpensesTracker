package com.dao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {

	SessionFactory sf = null;

	public ExpenseDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public boolean AddExpense(Expense e) {

		boolean flag = false;

		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();

			int i = (Integer) s.save(e);

			if (i > 0) {
				flag = true;
			}

			tx.commit();
			s.close();

		} catch (Exception e2) {
			System.out.println(e2);
		}

		return flag;
	}

	public List<Expense> getAllExpenses(User user) {

		List<Expense> list = new ArrayList<Expense>();

		try {
			Session s = sf.openSession();

			Query q = s.createQuery("from Expense as e where e.u=:user");
			q.setParameter("user", user);

			list = q.list();

			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public boolean DeleteExpense(int EId) {

		boolean flag = false;

		try {

			Session s = sf.openSession();

			Transaction tx = s.beginTransaction();

			Query q = s.createQuery("delete from Expense where Id=:Eid");
			q.setParameter("Eid", EId);
			int i = q.executeUpdate();
			if (i > 0) {
				flag = true;
			}

			tx.commit();
			s.close();

		} catch (Exception e2) {
			System.out.println(e2);
		}

		return flag;
	}

	public Expense getExpense(int EId) {

		Expense e = null;

		try {
			Session s = sf.openSession();

			Query q = s.createQuery("from Expense where Id=:eid");
			q.setParameter("eid", EId);

			e = (Expense) q.uniqueResult();

			s.close();

		} catch (Exception e2) {
			System.out.println(e2);
		}

		return e;
	}

	public boolean UpdateExpense(String Title, String Date, String Time, String Description, String Price, int EId) {

		boolean flag = false;

		try {
			Session s = sf.openSession();

			Transaction tx = s.beginTransaction();

			Query q = s.createQuery(
					"update Expense set Title=:title,Date=:date,Time=:time,Description=:des,Price=:price where Id=:eid");
			q.setParameter("title", Title);
			q.setParameter("date", Date);
			q.setParameter("time", Time);
			q.setParameter("des", Description);
			q.setParameter("price", Price);
			q.setParameter("eid", EId);

			int i = q.executeUpdate();

			if (i > 0) {
				flag = true;
			}

			tx.commit();
			s.close();

		} catch (Exception e2) {
			System.out.println(e2);
		}

		return flag;
	}

}
