package com.rentalexamplewebflux.bike_example_demo.lex;

import reactor.core.publisher.Flux;


//    public static void main(String[] args) {
//        //To create a simple
//        Flux<String> fruits=Flux.just("apple","Banana","jack","fruit");
//             fruits.subscribe(System.out::println);
//
//    }

   //Streaming Data in a REST API
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

    @RestController
    @RequestMapping("/stream")
    public class ToCreateStreams {

        @GetMapping("/numbers")
        public Flux<Integer> streamNumbers() {
            return Flux.range(1, 10).delayElements(Duration.ofSeconds(1));
            // Emits numbers 1 to 10 with a delay
        }
    }

