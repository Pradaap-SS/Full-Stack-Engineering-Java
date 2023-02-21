package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Locations;



@Repository
public interface LocationsRepo extends CrudRepository<Locations, Integer> {

	@Query(" FROM Locations")
	public List<Locations> fetchAllRecords();
}
