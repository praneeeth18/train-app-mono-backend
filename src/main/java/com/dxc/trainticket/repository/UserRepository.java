package com.dxc.trainticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.trainticket.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> findByEmail(String email);

}
