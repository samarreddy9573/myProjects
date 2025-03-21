package com.rentalexamplewebflux.bike_example_demo.bikerentall.controller;


import com.rentalexamplewebflux.bike_example_demo.bikerentall.RentalEntity;
import com.rentalexamplewebflux.bike_example_demo.bikerentall.servicerental.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @PostMapping("/rent/{bikeId}")
    public Mono<RentalEntity> rentBike(@PathVariable Long bikeId, @RequestParam String userName) {
        return rentalService.rentBike(bikeId, userName);
    }

    @PostMapping("/return/{rentalId}")
    public Mono<RentalEntity> returnBike(@PathVariable Long rentalId) {

        return rentalService.returnBike(rentalId);
    }
}