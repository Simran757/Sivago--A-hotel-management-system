package com.jsp.hotel_management_system.admin.dao;

import java.util.List;

import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class HotelOwnerdao {

	EntityManager em = Persistence.createEntityManagerFactory("hotelProject").createEntityManager();

	EntityTransaction et = em.getTransaction();

	public HotelOwner saveHotelOwnerDao(HotelOwner hotelOwner) {

		try {
			et.begin();
			em.persist(hotelOwner);
			et.commit();
			return hotelOwner;
		} catch (Exception e) {
			return null;
		}
	}

	public HotelOwner fetchHotelOwnerByEmailDao(String email) {

		Query query = em.createQuery("SELECT a FROM HotelOwner a where a.email=?1",HotelOwner.class);

		query.setParameter(1, email);

		try {
			
			Object object=query.getSingleResult();
			return (HotelOwner)object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * display All hotelOwner Details
	 */
	public List<HotelOwner> getAllHotelOwnerDetailsDao() {
		return em.createQuery("FROM HotelOwner").getResultList();
	}

	public int updateStatusToYesDao(String email) {

		Query query = em.createNativeQuery("update hotelowner set verify=?1 where email=?2");

		query.setParameter(1, "yes");
		query.setParameter(2, email);
		et.begin();
		int a = query.executeUpdate();
		et.commit();
		return a;
	}

	public int updateStatusToNoDao(String email) {

		Query query = em.createNativeQuery("update hotelowner set verify=?1 where email=?2");

		query.setParameter(1, "no");
		query.setParameter(2, email);
		et.begin();
		int a = query.executeUpdate();
		et.commit();
		return a;
	}
}
