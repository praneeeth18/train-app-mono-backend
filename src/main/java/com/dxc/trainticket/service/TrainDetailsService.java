package com.dxc.trainticket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dxc.trainticket.model.TrainDetails;
import com.dxc.trainticket.model.TrainDetailsRequest;
import com.dxc.trainticket.model.TrainSearchRequest;
import com.dxc.trainticket.repository.TrainDetailsRepository;

@Service
public class TrainDetailsService {
	
	@Autowired
	TrainDetailsRepository trainDetailsRepository;
	
	public ResponseEntity<String> addTrain(TrainDetailsRequest request) {
		try {
			var train = TrainDetails.builder()
					.trainName(request.getTrainName())
					.source(request.getSource())
					.destination(request.getDestination())
					.date(request.getDate())
					.build();
			trainDetailsRepository.save(train);
			return new ResponseEntity<>("Train successfully added!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Unsuccessfull", HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<TrainDetails>> getAllTrains() {
		try {
			return new ResponseEntity<>(trainDetailsRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<TrainDetails>> searchTrains(@RequestBody TrainSearchRequest params) {
        try {
            List<TrainDetails> trains = trainDetailsRepository.findTrainsBySourceDestinationAndDate(params);
            return new ResponseEntity<>(trains, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

}
