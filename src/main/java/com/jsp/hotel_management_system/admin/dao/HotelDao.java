package com.jsp.hotel_management_system.admin.dao;

import java.util.List;

import com.jsp.hotel_management_system.dto.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class HotelDao {
	@PersistenceContext
	EntityManager em = Persistence.createEntityManagerFactory("hotelProject").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Hotel saveHotelDao(Hotel hotel){
		try {
			et.begin();
			
			em.persist(hotel);
			et.commit();
			return hotel;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 
	 * getAllHotelDetails
	 * 
	 */
	public List<Hotel> getAllHotelDetailsDao() {
		return em.createQuery("FROM Hotel").getResultList();
	}

	/*
	 * delete method
	 */
	public boolean deleteHotelByIdDao(int id) {

		Hotel hotel = em.find(Hotel.class, id);
		if (hotel != null) {
			et.begin();
			em.remove(hotel);
			et.commit();
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * update hotel
	 */
	public Hotel updateHotelByIdDao(Hotel hotel) {
		
		Hotel hotel2=fetchHotelByIdDao(hotel.getId());
		
		if(hotel2!=null) {
			hotel2.setName(hotel.getName());
			hotel2.setAddress(hotel.getAddress());
			hotel2.setCity(hotel.getCity());
			hotel2.setPrice(hotel.getPrice());
			
			if(hotel.getImage()!=null) {
			   hotel2.setImage(hotel.getImage());
			}
			
			et.begin();
			em.merge(hotel2);
			et.commit();
			return hotel2;
		}else {
			return null;
		}
		
	}
/**
 * 
 * 
 * @param id
 * @return hotel
 * fetch hotel by id 
 */
	public Hotel fetchHotelByIdDao(int id) {
		
		return em.find(Hotel.class, id);
	}
	
	
	/**
	 * 
	 * 
	verify hotel by id 
	 */
	public Hotel verifyHotelByAdminDao(Hotel hotel) {
		et.begin();
		em.merge(hotel);
		et.commit();
		return hotel;
	}
	
	
}
