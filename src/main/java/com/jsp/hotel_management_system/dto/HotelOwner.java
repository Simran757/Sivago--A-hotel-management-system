package com.jsp.hotel_management_system.dto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class HotelOwner implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String verify;

	@OneToMany
	List<Hotel> hotels;

	public HotelOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * display
	 */
	public HotelOwner(int id, String name, String email, String password, long phone, String verify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify = verify;
	}
	
	/* register */
	public HotelOwner(String name, String email, String password, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify="no";
	}
}
