package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.UserDao;
import com.jsp.hotel_management_system.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/userRegister")
public class UserRegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		User user=new UserDao().saveUserDao(new User(name, email, password, phone));
		
		if(user!=null) {
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}