package com.example.cars;

import com.example.cars.domain.Car;
import com.example.cars.domain.dto.CarDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTests {

    @Autowired
    protected TestRestTemplate rest;


    // Auxiliary methods
    private ResponseEntity<CarDTO> getCar(String url) {
        return rest.withBasicAuth("user", "user").getForEntity(url, CarDTO.class);
    }

    private ResponseEntity<List<CarDTO>> getCars(String url) {
        return rest.withBasicAuth("user", "user").exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CarDTO>>() {});
    }

    @Test
    public void carsListTest() {
        List<CarDTO> cars = getCars("/api/cars").getBody();
        assertNotNull(cars);
        assertEquals(30, cars.size(), "Size mismatch for getCars");
    }

    @Test
    public void listByCategoryTest() {

        assertListSizeAndStatusOK(10, "classic");
        assertListSizeAndStatusOK(10, "sportive");
        assertListSizeAndStatusOK(10, "luxury");
        assertEquals(HttpStatus.NO_CONTENT, getCars("/api/cars/category/xxx").getStatusCode());
    }

    private void assertListSizeAndStatusOK(int expectedSize, String categoryEndpoint) {
        int actualSize = getCars("/api/cars/category/" + categoryEndpoint).getBody().size();
        HttpStatusCode actualStatus = getCars("/api/cars/category/" + categoryEndpoint).getStatusCode();
        assertEquals(expectedSize, actualSize, "Size mismatch for " + categoryEndpoint);
        assertEquals(HttpStatus.OK, actualStatus, "Status mismatch for " + categoryEndpoint);
    }

    @Test
    public void getCarTest() {
        ResponseEntity<CarDTO> response = getCar("/api/cars/11");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        CarDTO car = response.getBody();
        assertEquals("Ferrari FF", car.getName(), "Name mismatch for car 11");
    }

    @Test
    public void notFoundTest() {
        ResponseEntity<CarDTO> response = getCar("/api/cars/31");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void saveTest() {
        Car car = new Car();
        car.setName("Porshe");
        car.setCategory("sportive");

        // Test post
        ResponseEntity<Void> postResponse = rest.withBasicAuth("admin", "admin").postForEntity("/api/cars", car, null);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode(), "Status mismatch for save entity");
        System.out.println(postResponse);

        // Retrieve created object URL
        String location = postResponse.getHeaders().get("location").get(0);
        CarDTO getCar = getCar(location).getBody();
        assertNotNull(getCar);
        assertEquals("Porshe", getCar.getName(),
                "Name mismatch between created and retrieved car");
        assertEquals("sportive", getCar.getCategory(),
                "Category mismatch between created and retrieved car");

        // Delete created object
        rest.withBasicAuth("admin", "admin").delete(location);
        // Verify delete
        assertEquals(HttpStatus.NOT_FOUND, getCar(location).getStatusCode(),
                "Status mismatch when trying to delete entity");
    }
}
