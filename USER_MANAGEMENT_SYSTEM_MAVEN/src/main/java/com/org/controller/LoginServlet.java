package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.Userdao;
import com.org.dto.User;
@WebServlet("/login")
public class LoginServlet  extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		
		Userdao dao=  new Userdao();
		User user =dao.fetchUserByEmailAndPassword(email, password );
		HttpSession session = req.getSession();

		if(user !=null) {
			session.setAttribute("userObj", user);
			
			resp.sendRedirect("Home.jsp");
		}
		else {
			
			
			session.setAttribute("fail", "invalid credential");
			
			resp.sendRedirect("Login.jsp");
		}
	}
}
