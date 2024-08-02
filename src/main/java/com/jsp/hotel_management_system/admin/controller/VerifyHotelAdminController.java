package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelDao;
import com.jsp.hotel_management_system.dto.Hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet (value="/verifyHotelAdmin")
public class VerifyHotelAdminController extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	HotelDao dao=  new HotelDao();
	Hotel hotel=dao.fetchHotelByIdDao(id);
	
	if(hotel!=null) {
		if(hotel.getVerifyStatus().equalsIgnoreCase("no")) {
			hotel.setVerifyStatus("yes");
			dao.verifyHotelByAdminDao(hotel);
		}
	}
	
	req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
}
}
