package com.gapinc.booking.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gapinc.booking.repository.BookingRepository;
import com.gapinc.booking.util.JsonParam;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@PersistenceContext
	private EntityManager entityManager;

	public List findBooking(JsonParam param) {
		StringBuilder sql = new StringBuilder("SELECT * FROM BOOKING_V ");
		Query query = entityManager.createNativeQuery(sql.toString());
		return query.getResultList();
	}

}
