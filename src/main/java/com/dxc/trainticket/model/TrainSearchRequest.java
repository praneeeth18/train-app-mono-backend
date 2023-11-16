package com.dxc.trainticket.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class TrainSearchRequest {

	private String source;
	private String destination;
	private String date;
}
