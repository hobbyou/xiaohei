package com.gapinc.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapinc.booking.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

}