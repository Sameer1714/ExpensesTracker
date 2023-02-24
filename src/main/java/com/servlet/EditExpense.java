package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;

import com.dao.ExpenseDao;
import com.db.DBConnection;
import com.entity.Expense;

/**
 * Servlet implementation class EditExpense
 */
@WebServlet("/Editxpense")
public class EditExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id=Integer.parseInt(request.getParameter("Id"));
		
		String Title = request.getParameter("Title");
		String Date = request.getParameter("Date");
		String Time = request.getParameter("Time");
		String Description = request.getParameter("Description");
		String Price = request.getParameter("Price");
		
		ExpenseDao ed=new ExpenseDao(DBConnection.getSessionFactory());
		boolean flag=ed.UpdateExpense(Title, Date, Time, Description, Price, Id);
		
		HttpSession s=request.getSession();
		
		if(flag) {
			s.setAttribute("Success", "Expense Update Successfully");
			response.sendRedirect("User/ViewExpense.jsp");
		}
		else {
			s.setAttribute("Error", "Server Problem");
			response.sendRedirect("User/ViewExpense.jsp");
		}
		
	}

}
