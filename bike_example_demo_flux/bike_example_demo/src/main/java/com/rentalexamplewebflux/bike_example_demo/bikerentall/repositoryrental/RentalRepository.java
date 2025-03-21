package com.rentalexamplewebflux.bike_example_demo.bikerentall.repositoryrental;

import com.rentalexamplewebflux.bike_example_demo.bikerentall.RentalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RentalRepository extends ReactiveCrudRepository <RentalEntity,Long> {
}
