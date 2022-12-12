package com.peaksoft.service;

import com.peaksoft.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getCarById(Long id);
    Car saveCar(Car car);
    void deleteCarById(Long id);
}
