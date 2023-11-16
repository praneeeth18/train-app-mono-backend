package com.dxc.trainticket.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TrainDetailsRequest {
	
	private String trainName;
	private String source;
	private String destination;
	private String date;
}
