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

	private Integer userId;
    private Integer trainId;
    private List<Passenger> passengers;
}
