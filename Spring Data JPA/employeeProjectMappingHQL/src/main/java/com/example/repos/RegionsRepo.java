package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Regions;

@Repository
public interface RegionsRepo extends CrudRepository<Regions, Integer> {

	@Query(" FROM Regions")
	public List<Regions> fetchAllRecords();

}
