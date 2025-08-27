package com.wipro.tausif.bookingservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.bookingservice.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
