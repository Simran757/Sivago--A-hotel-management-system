package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jsp.hotel_management_system.admin.dao.HotelDao;
import com.jsp.hotel_management_system.admin.dao.HotelOwnerdao;
import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(value = "/hotelRegister")
@MultipartConfig(maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*5)
public class HotelRegisterController extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	String name=req.getParameter("name");
	String city=req.getParameter("city");
	String address=req.getParameter("address");
	double price=Double.parseDouble(req.getParameter("price"));
	Part part=req.getPart("image");
	InputStream inputstream=part.getInputStream();
	String email=(String)session.getAttribute("hownerSession");
	if(email!=null) {
		HotelOwner hotelOwner=new HotelOwnerdao().fetchHotelOwnerByEmailDao(email);
	Hotel hotel=new Hotel(name, city, address, price, inputstream.readAllBytes(), hotelOwner);
	Hotel hotel2=new HotelDao().saveHotelDao(hotel);
	if(hotel2!=null) {
	req.setAttribute("msg", "hotel registered");
	req.getRequestDispatcher("hotel-register.jsp").forward(req, resp);
	}else {
		req.setAttribute("msg", "hotel not registered");
		req.getRequestDispatcher("hotel-register.jsp").forward(req, resp);
	}
	}else {
		req.setAttribute("msg", "Please login with owner details");
		req.getRequestDispatcher("hotel-owner-login").forward(req, resp);
	}
}
}
