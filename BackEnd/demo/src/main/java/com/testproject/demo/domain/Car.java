package com.testproject.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String maker;
    private String name;
    private Integer horsePower;
    private Fuel fuel;
}
