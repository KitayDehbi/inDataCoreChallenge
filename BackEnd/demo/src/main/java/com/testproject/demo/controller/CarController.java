package com.testproject.demo.controller;

import com.testproject.demo.domain.Car;
import com.testproject.demo.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin
public class CarController {
    private final CarService carService;


    @GetMapping("/list")
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            return ResponseEntity.ok(carService.getAllCars());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/create")
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        carService.saveCar(car);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createRandomCar")
    public ResponseEntity<String> createRandomCar() {
        try {
            carService.saveCar();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("car created successfully");
    }

    @GetMapping("/carsByFuel")
    public ResponseEntity<List<Integer>> getSumCarsBYFuel() {
        try {
            return ResponseEntity.ok(carService.getSumCarsByFuel());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
