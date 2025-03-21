package com.rentalexamplewebflux.bike_example_demo.bikerentall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("rentals")
public class RentalEntity {
    @Id
    private Long id;
    private Long bikeId;
    private String userName;
    private LocalDateTime rentalTime;
    private LocalDateTime returnTime;
}
