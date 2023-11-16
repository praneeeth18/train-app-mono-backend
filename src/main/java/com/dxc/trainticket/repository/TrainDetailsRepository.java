package com.dxc.trainticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.dxc.trainticket.model.TrainDetails;
import com.dxc.trainticket.model.TrainSearchRequest;

@Repository
public interface TrainDetailsRepository extends JpaRepository<TrainDetails, Integer>{
	
	@Query("SELECT t FROM TrainDetails t WHERE t.source = :#{#params.source} AND t.destination = :#{#params.destination} AND t.date = :#{#params.date}")
    List<TrainDetails> findTrainsBySourceDestinationAndDate(@Param("params") TrainSearchRequest params);

}
