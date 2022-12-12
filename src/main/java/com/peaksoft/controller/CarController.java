package com.peaksoft.controller;

import com.peaksoft.entity.Car;
import com.peaksoft.entity.User;
import com.peaksoft.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping
    List<Car> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}
