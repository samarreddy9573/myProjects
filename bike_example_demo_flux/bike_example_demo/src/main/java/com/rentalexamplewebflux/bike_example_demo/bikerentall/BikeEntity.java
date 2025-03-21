package com.rentalexamplewebflux.bike_example_demo.bikerentall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("bikes")
public class BikeEntity {
    @Id
    private Long id;
    private String model;
    private Boolean Available;
}