package com.rentalexamplewebflux.bike_example_demo.lex.createreactivefunctionalstyle;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Component
public class StudentHandler {

    // Get a single student
    public Mono<ServerResponse> getStudentById(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<String> student = Mono.just("Student Name: Samar (ID: " + id + ")");
        return ServerResponse.ok().body(student, String.class);
    }

    // Get all students (Flux)
    public Mono<ServerResponse> getAllStudents(ServerRequest request) {
        Flux<String> students = Flux.just("Samar", "Reddy", "Srini")
                .delayElements(Duration.ofSeconds(1)); // Simulate streaming
        return ServerResponse.ok().body(students, String.class);
    }

    // Create a new student
    public Mono<ServerResponse> createStudent(ServerRequest request) {
        Mono<String> studentNameMono = request.bodyToMono(String.class);
        return studentNameMono.flatMap(name ->
                ServerResponse.ok().body(Mono.just("Student " + name + " created successfully!"), String.class)
        );
    }
}
