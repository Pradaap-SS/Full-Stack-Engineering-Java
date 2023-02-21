package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.JobHistory;


@Repository
public interface JobHistoryRepo extends CrudRepository<JobHistory, Integer> {

	@Query(" FROM JobHistory")
	public List<JobHistory> fetchAllRecords();
}

