package com.rentalexamplewebflux.bike_example_demo.bikerentall.controller;


import com.rentalexamplewebflux.bike_example_demo.bikerentall.BikeEntity;
import com.rentalexamplewebflux.bike_example_demo.bikerentall.servicerental.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {
    private final BikeService bikeService;

    @GetMapping("/available")
    public Flux<BikeEntity> getAvailableBikes() {
        return bikeService.getAvailableBikes();
    }

    @PostMapping("/book/{bikeId}")
    public Mono<BikeEntity> bookBike(@PathVariable Long bikeId) {
        return bikeService.bookBike(bikeId);
    }

    @PostMapping
    public Mono<BikeEntity> addBike(@RequestBody BikeEntity bikeEntity){
        Mono<BikeEntity> bike = bikeService.addBike(bikeEntity);
    return bike;
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> delById(@PathVariable Long id) {
        return bikeService.delById(id)
                .then(Mono.just(ResponseEntity.ok("Bike with ID " + id + " Have been deleted successfully.")));
    }
    @GetMapping("/get/{id}")
    public Mono<BikeEntity> findById(@PathVariable Long id){
        return bikeService.findBYId(id);
    }
}