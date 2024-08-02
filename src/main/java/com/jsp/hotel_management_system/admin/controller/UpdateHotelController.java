package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jsp.hotel_management_system.admin.dao.HotelDao;
import com.jsp.hotel_management_system.dto.Hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(value = "/hotelUpdate")
@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5,maxRequestSize=1024*1024*5*5)
public class UpdateHotelController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		String address = req.getParameter("address");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Part part = req.getPart("image");
		
		Hotel hotel=null;
		
		System.out.println(part);
		
		if(part!=null) {
			InputStream inputStream = part.getInputStream();
			hotel=new Hotel(id, name, city, address, price, inputStream.readAllBytes());
		}else {
			hotel=new Hotel(id, name, city, address, price, null);
		}

		Hotel hotel1=new HotelDao().updateHotelByIdDao(hotel);
		
		req.getRequestDispatcher("home-hotel-owner.jsp").forward(req, resp);
	}
}
