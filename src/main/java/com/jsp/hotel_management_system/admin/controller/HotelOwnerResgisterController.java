package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelOwnerdao;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/hotelOwnerRegister")
public class HotelOwnerResgisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		HotelOwner owner = new HotelOwner(email, name, password, phone);

		HotelOwner owner2 = new HotelOwnerdao().saveHotelOwnerDao(owner);
		if (owner2 != null) {
			System.out.println("registered");
			req.setAttribute("msg", "Registerd!");
			req.getRequestDispatcher("hotel-owner-login.jsp").forward(req, resp);
		} else {
			System.out.println("not ");
			req.setAttribute("msg", " Not Registerd!");
			req.getRequestDispatcher("register-hotel-owner.jsp").forward(req, resp);
		}
	}

}
