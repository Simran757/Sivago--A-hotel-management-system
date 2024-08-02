package com.jsp.hotel_management_system.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private String address;
	private double price;
	@Column(name = "verifystatus")
	private String verifyStatus;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@ManyToOne
	private HotelOwner hotelOwner;

	public Hotel(String name, String city, String address, double price, byte[] image, HotelOwner hotelOwner) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.price = price;
		this.image = image;
		this.hotelOwner = hotelOwner;
		this.verifyStatus="no";
	}

	public Hotel(int id, String name, String city, String address, double price, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.price = price;
		this.image = image;
	}
	
	
	
	
	
}

