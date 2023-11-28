package com.dxc.trainticket.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class BookingRequest {

	private String userEmail;
    private Integer trainId;
    private Integer price;
    private String status;
    private List<Passenger> passengers;
}
