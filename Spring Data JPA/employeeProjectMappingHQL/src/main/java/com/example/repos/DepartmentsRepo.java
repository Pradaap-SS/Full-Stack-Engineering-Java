package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Departments;



@Repository
public interface DepartmentsRepo extends CrudRepository<Departments, Integer> {
	
	@Query(" FROM Departments")
	public List<Departments> fetchAllRecords();

}
