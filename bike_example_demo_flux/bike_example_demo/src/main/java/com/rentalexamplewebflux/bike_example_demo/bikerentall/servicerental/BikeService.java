package com.rentalexamplewebflux.bike_example_demo.bikerentall.servicerental;


import com.rentalexamplewebflux.bike_example_demo.bikerentall.BikeEntity;
import com.rentalexamplewebflux.bike_example_demo.bikerentall.repositoryrental.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;

    public Flux<BikeEntity> getAvailableBikes(){
        return bikeRepository.findByAvailableTrue();
    }

    public Mono<BikeEntity> bookBike(Long bikeId) {
        return bikeRepository.findById(bikeId)
                .flatMap(bike -> {
                    if (bike.getAvailable()) {
                        bike.setAvailable(false);
                        return bikeRepository.save(bike);
                    } else {
                        return Mono.error(new RuntimeException("Bike is not available:Already Booked"));
                    }
                });
    }

    public Mono<BikeEntity> addBike(BikeEntity bikeEntity){
        return bikeRepository.save(bikeEntity);
    }

    public   Mono<Void> delById(Long bikeId){
        return bikeRepository.deleteById(bikeId);
    }

    public Mono<BikeEntity> findBYId(Long bikeId){
        return bikeRepository.findById(bikeId);
    }
}
