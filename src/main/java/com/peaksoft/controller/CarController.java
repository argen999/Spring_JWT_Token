package com.peaksoft.controller;

import com.peaksoft.entity.Car;
import com.peaksoft.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    List<Car> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('VENDOR')")
    Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('VENDOR')")
    void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }
}
