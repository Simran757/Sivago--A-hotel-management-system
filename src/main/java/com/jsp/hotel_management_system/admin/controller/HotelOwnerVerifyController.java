package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelOwnerdao;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/verifyController")
public class HotelOwnerVerifyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		HotelOwnerdao dao = new HotelOwnerdao();
		
		String email = req.getParameter("email");

		System.out.println(email);
		
		if(httpSession.getAttribute("adminSession")!=null) {
			HotelOwner owner=dao.fetchHotelOwnerByEmailDao(email);
			
			if(owner.getVerify().equalsIgnoreCase("yes")) {
				dao.updateStatusToNoDao(email);
			}else {
				dao.updateStatusToYesDao(email);
			}
			resp.sendRedirect("admin-home.jsp");
		}else {
			req.setAttribute("msg","please login with admin and perform task...");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
		
	}
}
