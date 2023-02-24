package com.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Expense;
import com.entity.User;

public class DBConnection {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			Configuration c = new Configuration();

			Properties p = new Properties();

			p.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			p.put(Environment.URL, "jdbc:mysql://localhost:3306/expensetracker");
			p.put(Environment.USER, "root");
			p.put(Environment.PASS, "");
			p.put(Environment.DIALECT, "org.hibernate.dialect.MariaDBDialect");
			p.put(Environment.HBM2DDL_AUTO, "update");
			p.put(Environment.SHOW_SQL, "true");
			p.put(Environment.FORMAT_SQL, "true");

			c.setProperties(p);

			c.addAnnotatedClass(User.class);
			c.addAnnotatedClass(Expense.class);

			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();

			sessionFactory = c.buildSessionFactory(sr);

		}

		return sessionFactory;
	}
}
