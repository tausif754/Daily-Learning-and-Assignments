package com.wipro.tausif.roomservice.controller;


import org.springframework.web.bind.annotation.*;

import com.wipro.tausif.roomservice.entity.Room;
import com.wipro.tausif.roomservice.repository.RoomRepository;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        updatedRoom.setId(id);
        return repository.save(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

