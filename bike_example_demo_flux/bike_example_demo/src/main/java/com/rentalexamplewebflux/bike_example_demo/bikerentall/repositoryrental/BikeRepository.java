package com.rentalexamplewebflux.bike_example_demo.bikerentall.repositoryrental;


import com.rentalexamplewebflux.bike_example_demo.bikerentall.BikeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BikeRepository extends ReactiveCrudRepository<BikeEntity, Long> {
    Flux<BikeEntity> findByAvailableTrue();
}
