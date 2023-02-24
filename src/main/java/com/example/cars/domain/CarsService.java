package com.example.cars.domain;

import com.example.cars.domain.dto.CarDTO;
import com.example.cars.domain.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    @Autowired
    private CarRepository repository;

    public List<CarDTO> getCars() {
        return repository.findAll().stream().map(CarDTO::create).toList();
    }

    public CarDTO getById(Long id) {
        return repository.findById(id).map(CarDTO::create)
                .orElseThrow(() -> new ObjectNotFoundException("Could not find car."));
    }

    public List<CarDTO> getByCategory(String category) {
       return repository.findByCategory(category).stream().map(CarDTO::create).toList();
    }

    public CarDTO insert(Car car) {
        Assert.isNull(car.getId(), "Could not registrate car. ID cannot be set.");
        Assert.notNull(car.getName(), "Could not registrate car. Name cannot be null.");
        return CarDTO.create(repository.save(car));
    }

    public CarDTO update(Long id, Car car) {
        Assert.notNull(id, "Could not update the registration. ID cannot be set.");
        Optional<Car> optional = repository.findById(id);
        if (optional.isPresent()) {
            Car dbCar = optional.get();
            if (car.getName() != null) {
                dbCar.setName(car.getName());
            }
            if (car.getCategory() != null) {
                if (car.getCategory().equals("null")) {
                    dbCar.setCategory(null);
                } else {
                    dbCar.setCategory(car.getCategory());
                }
            }
            if (car.getDescription() != null) {
                if (car.getDescription().equals("null")) {
                    dbCar.setDescription(null);
                } else {
                    dbCar.setDescription(car.getDescription());
                }
            }
            return CarDTO.create(repository.save(dbCar));
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
