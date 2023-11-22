package com.dxc.trainticket.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Passenger {

    private Integer passengerId;
    private String name;
    private String gender;
    private String dob;
    private String phoneNumber;
}
