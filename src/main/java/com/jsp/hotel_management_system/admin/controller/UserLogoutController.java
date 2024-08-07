package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/userLogout")
public class UserLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("userSession")!=null) {
			httpSession.invalidate();
			req.setAttribute("msg", "logout success");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}