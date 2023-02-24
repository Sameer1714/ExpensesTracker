package com.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String Title;

	private String Date;

	private String Time;

	private String Description;

	private String Price;

	@ManyToOne(cascade = CascadeType.ALL)
	private User u;

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Expense(int id, String title, String date, String time, String description, String price, User u) {
		super();
		Id = id;
		Title = title;
		Date = date;
		Time = time;
		Description = description;
		Price = price;
		this.u = u;
	}



	public Expense(String title, String date, String time, String description, String price, User u) {
		super();
		Title = title;
		Date = date;
		Time = time;
		Description = description;
		Price = price;
		this.u = u;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
