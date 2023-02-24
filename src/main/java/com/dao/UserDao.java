package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;

public class UserDao {

	SessionFactory sessionFactory = null;

	public UserDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean save(User u) {

		boolean flag = false;
       
		try {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		int i = (Integer) s.save(u);

		if (i > 0) {
			flag = true;
		}

		tx.commit();
		s.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return flag;
	}
	
	
	public User CheckUserLogin(String Email,String Password) {
		
		User u=null;
		
		
			
			Session s=sessionFactory.openSession();
			
			Query q=s.createQuery("from User as u where u.Email=:em and u.Password=:ps ");
			
			 q.setParameter("em", Email);
			 q.setParameter("ps", Password);
			 
			 u = (User) q.uniqueResult();
		
		
		
		return u;
	}
}
