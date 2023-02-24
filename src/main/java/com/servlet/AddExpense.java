package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.DBConnection;
import com.entity.Expense;
import com.entity.User;

@WebServlet("/AddExpense")
public class AddExpense extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Title = req.getParameter("Title");
		String Date = req.getParameter("Date");
		String Time = req.getParameter("Time");
		String Description = req.getParameter("Description");
		String Price = req.getParameter("Price");

		HttpSession s = req.getSession();

		User u = (User) s.getAttribute("User");

		Expense e = new Expense(Title, Date, Time, Description, Price, u);

		ExpenseDao ed = new ExpenseDao(DBConnection.getSessionFactory());
		boolean flag = ed.AddExpense(e);

		if (flag) {
			s.setAttribute("Success", "Sucessfully Expense Add");
			resp.sendRedirect("User/AddExpense.jsp");
		} else {
			s.setAttribute("Error", "Server Problem");
			resp.sendRedirect("User/AddExpense.jsp");
		}

	}

}
