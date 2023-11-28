package com.dxc.trainticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.dxc.trainticket.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b FROM Booking b WHERE b.userEmail = :userEmail")
    List<Booking> findByUserEmail(@PathVariable("userEmail") String userEmail);
}
