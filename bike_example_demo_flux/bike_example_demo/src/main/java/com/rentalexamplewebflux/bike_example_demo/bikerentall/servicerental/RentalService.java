package com.rentalexamplewebflux.bike_example_demo.bikerentall.servicerental;


import com.rentalexamplewebflux.bike_example_demo.bikerentall.RentalEntity;
import com.rentalexamplewebflux.bike_example_demo.bikerentall.repositoryrental.BikeRepository;
import com.rentalexamplewebflux.bike_example_demo.bikerentall.repositoryrental.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BikeRepository bikeRepository;

    public Mono<RentalEntity> rentBike(Long bikeId, String userName) {
        return bikeRepository.findById(bikeId)
                .flatMap(bike -> {
                    if (bike.getAvailable()) {
                        bike.setAvailable(false);
                        return bikeRepository.save(bike)
                                .then(rentalRepository.save
                                        (new RentalEntity(null, bikeId, userName, LocalDateTime.now(),
                                                null)));
                    } else {
                        return Mono.error(new RuntimeException("Bike is not available"));
                    }
                });
    }

    public Mono<RentalEntity> returnBike(Long rentalId) {
        return rentalRepository.findById(rentalId)
                .flatMap(rental -> {
                    rental.setReturnTime(LocalDateTime.now());
                    return rentalRepository.save(rental)
                            .flatMap(updatedRental -> bikeRepository.findById(updatedRental.getBikeId())
                                    .flatMap(bike -> {
                                        bike.setAvailable(true);
                                        return bikeRepository.save(bike).thenReturn(updatedRental);
                                    })
                            );
                });
    }

}





