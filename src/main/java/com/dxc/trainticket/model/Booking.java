package com.dxc.trainticket.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue
	private Integer bookingId;
    private String userEmail;
    private Integer price;
    
 // Set the default value of status as "PENDING"
    @Builder.Default
    private String status = "PENDING";
	
	@ManyToOne
    @JoinColumn(name = "train_id") // This is the foreign key to link Booking to TrainDetails
    private TrainDetails trainDetails;
	
	@ElementCollection
    @CollectionTable(name = "passengers", joinColumns = @JoinColumn(name = "booking_id"))
    private List<Passenger> passengers;
}
