package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnection;
import com.entity.User;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String About=request.getParameter("About");
		String Password=request.getParameter("Password");
		String CPassword=request.getParameter("CPassword");
		
		HttpSession s=request.getSession();
		
		if(Password.equals(CPassword)) {
			
			User u=new User(Name, Email, About, CPassword);
			
			UserDao ud=new UserDao(DBConnection.getSessionFactory());
			 boolean flag=ud.save(u);
			
			 if(flag) {
				 s.setAttribute("Success", "Register Successfully");
				 response.sendRedirect("Register.jsp");
			 }
			 else {
				 s.setAttribute("Error", "Server Problem");
					response.sendRedirect("Register.jsp");
			 }
			
			
		}
		else {
			s.setAttribute("Error", "Password Not Match");
			response.sendRedirect("Register.jsp");
		}
		
	}

}
