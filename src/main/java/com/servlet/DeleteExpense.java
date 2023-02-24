package com.servlet;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.DBConnection;

@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id=Integer.parseInt(request.getParameter("Id"));
		
		ExpenseDao ed=new ExpenseDao(DBConnection.getSessionFactory());
		Boolean flag=ed.DeleteExpense(Id);
		
		HttpSession s=request.getSession();
		
		if(flag) {
			
			s.setAttribute("Success", "Expense Delete Successfully");
			response.sendRedirect("User/ViewExpense.jsp");
		}
		else {
			s.setAttribute("Erroe", "Server Problem");
			response.sendRedirect("User/ViewExpense.jsp");
		}
	}

}
