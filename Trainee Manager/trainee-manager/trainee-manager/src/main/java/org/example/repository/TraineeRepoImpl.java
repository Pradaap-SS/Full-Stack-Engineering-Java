package org.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Trainee;

public class TraineeRepoImpl implements TraineeRepo {

	private Map<String, List<Trainee>> traineeDataSource = new HashMap<>();

	@Override
	public void registerTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException {
		
		for (Map.Entry<String, List<Trainee>> entry : traineeDataSource.entrySet()) {
			for (Trainee obj : entry.getValue()) {
				if (obj.getEmpid().equals(trainee.getEmpid())) {
					
					throw new InvalidTraineeOperationException("Trainee already exist in cohort " + entry.getKey());
				}
			}
		}
		if (traineeDataSource.containsKey(cohort)) {
			traineeDataSource.get(cohort).add(trainee);
		} else {
			List<Trainee> list = new ArrayList<>();
			list.add(trainee);
			traineeDataSource.put(cohort, list);
		}

	}

	@Override
	public void removeTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException {
		List<Trainee> list = traineeDataSource.get(cohort);
		if(!list.isEmpty()) {
			list.remove(list.indexOf(trainee));
		}else {
			throw new InvalidTraineeOperationException("No trainees in this cohort");
		}
	}

	@Override
	public Trainee findByName(String cohort, String fullName) throws InvalidTraineeOperationException {
		if (traineeDataSource.containsKey(cohort)) {
			for (Trainee t : traineeDataSource.get(cohort)) {
				if((t.getFirstName()+" "+t.getLastName()).equalsIgnoreCase(fullName)){
					return t;
				}
			}
		} else {
			throw new InvalidTraineeOperationException("Cohort " + cohort + " does not present");
		}
		throw new InvalidTraineeOperationException("Trainee " + fullName + " not present under cohort " + cohort);
	}

	@Override
	public List<Trainee> findAll(String cohort) {
		return traineeDataSource.get(cohort);
	}
}
