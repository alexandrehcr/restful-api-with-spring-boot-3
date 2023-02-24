package com.example.cars;

import com.example.cars.domain.Car;
import com.example.cars.domain.CarsService;
import com.example.cars.domain.dto.CarDTO;
import com.example.cars.domain.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceTests {

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
		carDTO = service.getById(id);
		assertNotNull(carDTO);

		// Compare if the data added is what was intended to be.
		assertEquals("Ferrari", carDTO.getName());
		assertEquals("sportive", carDTO.getCategory());

		// Delete generated object and check deletion
		service.deleteById(id);
		try {
			service.getById(id);
			fail("Car was not deleted.");
		} catch (ObjectNotFoundException e) {
			// ok
		}
	}

	@Test
	public void tableSize() {
		List<CarDTO> cars = service.getCars();
		assertEquals(30, cars.size());
	}

	@Test
	public void getTest() {
		CarDTO carDTO = service.getById(11L);
		assertNotNull(carDTO);
		assertEquals("Ferrari FF", carDTO.getName());
	}

	@Test
	public void getByCategoryTest() {
		assertEquals(10, service.getByCategory("classic").size());
		assertEquals(10, service.getByCategory("sportive").size());
		assertEquals(10, service.getByCategory("luxury").size());
		assertEquals(0, service.getByCategory("x").size());
	}
}
