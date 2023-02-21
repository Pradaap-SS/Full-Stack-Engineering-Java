package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Employees;


@Repository
public interface EmployeesRepo extends CrudRepository<Employees, Integer> {

	@Query(" FROM Employees")
	public List<Employees> fetchAllRecords();
}
