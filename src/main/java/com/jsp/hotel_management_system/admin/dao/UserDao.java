package com.jsp.hotel_management_system.admin.dao;

import com.jsp.hotel_management_system.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDao {

	EntityManager em = Persistence.createEntityManagerFactory("hotel-project").createEntityManager();

	EntityTransaction et = em.getTransaction();

	public User saveUserDao(User user) {

		try {
			et.begin();
			em.persist(user);
			et.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User loginUserByEmailAndPasswordDao(String email) {
		Query query=em.createNativeQuery("select * from user where email=?1",User.class);
		query.setParameter(1, email);
		try {
			return (User)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}