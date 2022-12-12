package com.peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @SequenceGenerator(name = "car_seq", sequenceName = "car_seq", allocationSize = 1)
    @GeneratedValue(generator = "car_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String model;

    private String name;

}
