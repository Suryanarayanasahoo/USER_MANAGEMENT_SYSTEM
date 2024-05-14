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

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet
 {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String ageStr=req.getParameter("age");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobileStr=req.getParameter("mobile");
		
		int age=Integer.parseInt(ageStr);
		long mobile=Long.parseLong(mobileStr);
		
		User user=new User();
		user.setName(name);
		user.setAge(age); 
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile(mobile);
		
		Userdao obj= new Userdao();
		obj.saveUser(user);
		
		HttpSession session = req.getSession();
		session.setAttribute("success", "Registration successful");
		
		
		resp.sendRedirect("Register.jsp");
		
		
	}

}