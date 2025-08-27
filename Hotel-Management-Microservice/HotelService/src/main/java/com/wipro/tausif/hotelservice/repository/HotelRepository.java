package com.wipro.tausif.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	

}
