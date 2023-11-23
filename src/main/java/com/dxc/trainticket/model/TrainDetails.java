package com.dxc.trainticket.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainDetails {

	@Id
	@GeneratedValue
	private Integer trainId;
	private String trainName;
	private String trainNumber;
	private String source;
	private String destination;
	private String classes;
	private String quota;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String date;
	private String departure;
	private String arrival;

//	public String getFormattedDate() {
//        return date;
//    }
//
//    public void setFormattedDate(String formattedDate) {
//        this.date = formattedDate;
//    }
}
