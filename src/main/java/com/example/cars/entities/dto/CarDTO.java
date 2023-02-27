package com.example.cars.entities.dto;

import com.example.cars.entities.Car;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarDTO {
    private Long id;
    private String name;
    private String category;
    private String description;

    public static CarDTO create(Car car) {
        ModelMapper modelMapper = new ModelMapper();
       return modelMapper.map(car, CarDTO.class);
    }
}
