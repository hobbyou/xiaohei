package com.gapinc.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gapinc.booking.domain.Booking;

@Repository
public interface ProductRepository extends JpaRepository<Booking, String> {

}