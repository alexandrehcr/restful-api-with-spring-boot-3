package com.example.cars;

import com.example.cars.domain.Car;
import com.example.cars.domain.CarsService;
import com.example.cars.domain.dto.CarDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarsApplicationTests {

	@Autowired
	CarsService service;

	@Test
	public void insertTest() {
		Car car = new Car();
		car.setName("Ferrari");
		car.setCategory("sportive");

		// CarsService::insert returns a CarDTO if the object is inserted.
		CarDTO carDTO = service.insert(car);
		assertNotNull(carDTO);

		// Inserted object must have an ID.
		Long id = carDTO.getId();
		assertNotNull(id);

		// Retrieve the object through its assigned ID
		Optional<CarDTO> optional = service.getById(id);
		assertTrue(optional.isPresent());

		// Compare if the data added is what was intended to be.
		carDTO = optional.get();
		assertEquals("Ferrari", carDTO.getName());
		assertEquals("sportive", carDTO.getCategory());

		// Verifies if the object was deleted
		service.deleteById(id);
		assertFalse(service.getById(id).isPresent());
	}

	@Test
	public void tableSize() {
		List<CarDTO> cars = service.getCars();
		assertEquals(30, cars.size());
	}

	@Test
	public void getTest() {
		Optional<CarDTO> optional = service.getById(11L);
		assertTrue(optional.isPresent());

		CarDTO car = optional.get();
		assertEquals("Ferrari FF", car.getName());
	}

	@Test
	public void getByCategoryTest() {
		assertEquals(10, service.getByCategory("classic").size());
		assertEquals(10, service.getByCategory("sportive").size());
		assertEquals(10, service.getByCategory("luxury").size());
		assertEquals(0, service.getByCategory("x").size());
	}
}
