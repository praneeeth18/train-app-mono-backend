package com.dxc.trainticket.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.trainticket.model.TrainDetails;
import com.dxc.trainticket.model.TrainDetailsRequest;
import com.dxc.trainticket.model.TrainSearchRequest;
import com.dxc.trainticket.service.TrainDetailsService;

@RestController
@RequestMapping("/api/v1/trainDetails")
public class TrainDetailsController {
	
	@Autowired
	TrainDetailsService trainDetailsService;
	
	@PostMapping
	public ResponseEntity<String> addTrain(@RequestBody TrainDetailsRequest train) {
		return trainDetailsService.addTrain(train);
	}
	
	@PostMapping("/searchTrains")
    public ResponseEntity<List<TrainDetails>> searchTrains(@RequestBody TrainSearchRequest params) {
        return trainDetailsService.searchTrains(params);
    }
	
	@GetMapping("/getAllTrains")
	public ResponseEntity<List<TrainDetails>> getAllTrains() {
		return trainDetailsService.getAllTrains();
	}

}
