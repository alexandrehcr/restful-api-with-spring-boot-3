package com.example.cars.api;

import com.example.cars.domain.Car;
import com.example.cars.domain.CarsService;
import com.example.cars.domain.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    @Autowired
    private CarsService service;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll(){
        return ResponseEntity.ok(service.getCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable("id") Long id) {
        Optional<CarDTO> optional = service.getById(id);
        return optional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<CarDTO>> getByCategory(@PathVariable("category") String category) {
        List<CarDTO> list = service.getByCategory(category);

        return list.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Car car){
        try {
            CarDTO createdCar = service.insert(car);
            URI location = getUri(createdCar.getId());
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> put(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        CarDTO updatedCar = service.update(id, car);

        return updatedCar != null ?
                ResponseEntity.ok(updatedCar) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return service.deleteById(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
