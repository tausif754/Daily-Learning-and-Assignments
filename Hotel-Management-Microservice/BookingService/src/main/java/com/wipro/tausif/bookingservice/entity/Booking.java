package com.wipro.tausif.bookingservice.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // Reference to User Service
    private Long roomId;  // Reference to Room Service
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
