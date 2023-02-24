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

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Email=req.getParameter("Email");
		String Password=req.getParameter("Password");
		
		
		
		UserDao ud=new UserDao(DBConnection.getSessionFactory());
		User u=ud.CheckUserLogin(Email, Password);
		
		HttpSession s=req.getSession();
		
		if(u != null && Email.equals(u.getEmail()) && Password.equals(u.getPassword())) {
			
			s.setAttribute("User", u);
			resp.sendRedirect("User/UserDashboard.jsp");
			
		}
		else {
			s.setAttribute("Error", "Invalid Password or Email");
			resp.sendRedirect("Login.jsp");
		}
		
		
	}

	
}
