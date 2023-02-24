package com.example.cars.api;

import com.example.cars.domain.Car;
import com.example.cars.domain.CarsService;
import com.example.cars.domain.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    @Autowired
    private CarsService service;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll(){
        List<CarDTO> list = service.getCars();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable("id") Long id) {
        CarDTO carDTO = service.getById(id);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<CarDTO>> getByCategory(@PathVariable("category") String category) {
        List<CarDTO> list = service.getByCategory(category);

        return list.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(list);
    }

    @PostMapping
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Void> post(@RequestBody Car car){
        CarDTO createdCar = service.insert(car);
        URI location = getUri(createdCar.getId());
        return ResponseEntity.created(location).build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }


    @PutMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<CarDTO> put(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        CarDTO updatedCar = service.update(id, car);

        return updatedCar != null ?
                ResponseEntity.ok(updatedCar) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
