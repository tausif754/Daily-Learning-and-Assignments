package com.wipro.tausif.roomservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.tausif.roomservice.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

