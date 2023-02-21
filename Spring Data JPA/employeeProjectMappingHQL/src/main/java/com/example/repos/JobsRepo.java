package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Jobs;

@Repository
public interface JobsRepo extends CrudRepository<Jobs, Integer> {

	@Query(" FROM Jobs")
	public List<Jobs> fetchAllRecords();
}
