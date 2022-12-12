package com.peaksoft.service.serviceimpl;

import com.peaksoft.entity.Car;
import com.peaksoft.repository.CarRepository;
import com.peaksoft.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        if (!carRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    String.format("Car via id = %d not found!", id)
            );
        }
        carRepository.deleteById(id);
    }

}
