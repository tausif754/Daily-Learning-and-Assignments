package com.wipro.tausif.hotelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wipro.tausif.hotelservice.entity.Hotel;
import com.wipro.tausif.hotelservice.repository.HotelRepository;

import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;

    public Hotel saveHotel(Hotel hotel) {
        return repository.save(hotel);
    }

    public Page<Hotel> getAllHotels(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Optional<Hotel> getHotelById(Long id) {
        return repository.findById(id);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        return repository.findById(id)
                .map(hotel -> {
                    hotel.setName(updatedHotel.getName());
                    hotel.setLocation(updatedHotel.getLocation());
                    hotel.setRating(updatedHotel.getRating());
                    hotel.setDescription(updatedHotel.getDescription());
                    return repository.save(hotel);
                })
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public void deleteHotel(Long id) {
        repository.deleteById(id);
    }
}
