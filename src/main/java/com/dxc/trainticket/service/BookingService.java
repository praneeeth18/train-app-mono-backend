package com.dxc.trainticket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dxc.trainticket.model.Booking;
import com.dxc.trainticket.model.BookingRequest;
import com.dxc.trainticket.model.Passenger;
import com.dxc.trainticket.model.TrainDetails;
import com.dxc.trainticket.model.User;
import com.dxc.trainticket.repository.BookingRepository;
import com.dxc.trainticket.repository.TrainDetailsRepository;
import com.dxc.trainticket.repository.UserRepository;

@Service
public class BookingService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TrainDetailsRepository trainDetailsRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	public ResponseEntity<List<Booking>> getAllBookings() {
		try {
			return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
    }
    
    
    public ResponseEntity<Booking> makeBooking(BookingRequest bookingRequest) {
        // Retrieve user and train details from the database based on the IDs in the booking request
        User user = userRepository.findById(bookingRequest.getUserId()).orElse(null);
        TrainDetails trainDetails = trainDetailsRepository.findById(bookingRequest.getTrainId()).orElse(null);

        // Check if user and train details exist
        if (user == null || trainDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
     // Create a list to store Passenger objects
        List<Passenger> passengers = new ArrayList<>();
        
     // Iterate through passenger details in the request and create Passenger objects
        for (Passenger passengerDetails : bookingRequest.getPassengers()) {
            Passenger passenger = Passenger.builder()
                    .name(passengerDetails.getName())
                    .gender(passengerDetails.getGender())
                    .dob(passengerDetails.getDob())
                    .phoneNumber(passengerDetails.getPhoneNumber())
                    .build();
            // Add the passenger to the list
            passengers.add(passenger);
        }
        
        //Create a new Booking object
        Booking booking = Booking.builder()
                .userId(bookingRequest.getUserId())
                .trainDetails(trainDetails)
                .passengers(passengers)
                .build();

        // Save the booking to the database
        Booking savedBooking = bookingRepository.save(booking);

        // Save the updated booking with associated passengers
        bookingRepository.save(savedBooking);

        // Optionally, you can return the saved booking in the response
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }


}
