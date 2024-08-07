package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.UserDao;
import com.jsp.hotel_management_system.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/userLogin")
public class UserLoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user=new UserDao().loginUserByEmailAndPasswordDao(email);
		
		if(user!=null) {
			
			if(user.getPassword().equals(password)) {
				httpSession.setAttribute("userSession", email);
				req.getRequestDispatcher("user-home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "invalid password");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "invalid email");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
		
	}
}