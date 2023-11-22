package com.dxc.trainticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.trainticket.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
