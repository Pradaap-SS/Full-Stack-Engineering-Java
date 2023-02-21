package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Countries;


@Repository
public interface CountriesRepo extends CrudRepository<Countries, Integer> {

	@Query(" FROM Countries")
	public List<Countries> fetchAllRecords();

	/*
	 * @Query(" FROM Countries where region_id=:id") public Countries
	 * fetchRecordsById(@Param("region_id") int id);
	 */
}
