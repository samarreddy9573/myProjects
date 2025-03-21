package com.rentalexamplewebflux.bike_example_demo.lex.createreactivefunctionalstyle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StudentRouter {

    @Bean
    public RouterFunction<ServerResponse> studentRoutes(StudentHandler handler) {
        return route(GET("/students/{id}"), handler::getStudentById)
                .andRoute(GET("/students"), handler::getAllStudents)
                .andRoute(POST("/students"), handler::createStudent);
    }
}

