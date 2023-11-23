package com.dxc.trainticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private String classes;
	private String quota;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String date;
	
}
