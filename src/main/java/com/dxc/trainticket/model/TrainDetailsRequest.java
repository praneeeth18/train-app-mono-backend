package com.dxc.trainticket.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TrainDetailsRequest {
	
	private String trainName;
	private String trainNumber;
	private String source;
	private String destination;
	private String classes;
	private String quota;
	private String date;
	private String departure;
	private String arrival;
}
