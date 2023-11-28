package com.dxc.trainticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.trainticket.model.User;
import com.dxc.trainticket.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
//	public Optional<User> findByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
	
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }
	
	public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
