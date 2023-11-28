package com.dxc.trainticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.trainticket.model.Booking;
import com.dxc.trainticket.model.BookingRequest;
import com.dxc.trainticket.service.BookingService;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	@PostMapping("/make-booking")
	public ResponseEntity<Booking> makeBooking(@RequestBody BookingRequest bookingRequest) {
		return bookingService.makeBooking(bookingRequest);
	}

	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
        return bookingService.getAllBookings();
    }
	
	@GetMapping("/getBookingById/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer bookingId) {
        return bookingService.getBookingById(bookingId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PutMapping("/update/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody BookingRequest updatedBookingRequest) {
        return bookingService.updateBooking(bookingId, updatedBookingRequest);
    }
	
	@GetMapping("/getBooking/{userEmail}")
    public ResponseEntity<List<Booking>> getBookingsByUserEmail(@PathVariable String userEmail) {
        return bookingService.getBookingsByUserEmail(userEmail);
    }
}
