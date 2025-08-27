package com.wipro.tausif.roomservice.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type;       // Single, Double, Suite
    private Double price;
    private Boolean available;
}
