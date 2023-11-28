package com.dxc.trainticket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.trainticket.model.User;
import com.dxc.trainticket.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        try {
        	return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e) {
        	e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<User> optionalUser = userService.getUserById(id);
		if(optionalUser.isPresent()) {
			return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
		Optional<User> optionalUser = userService.getUserByEmail(email);
		if(optionalUser.isPresent()) {
			return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
	}

}
