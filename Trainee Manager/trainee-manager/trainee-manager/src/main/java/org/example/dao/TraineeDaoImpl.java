package org.example.dao;

import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Trainee;
import org.example.repository.TraineeRepoImpl;

import java.util.List;

public class TraineeDaoImpl implements TraineeDao{
	
	private TraineeRepoImpl traineeRepo = new TraineeRepoImpl();

    @Override
    public void registerTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException {
    	traineeRepo.registerTrainee(cohort, trainee);
    }

    @Override
    public void removeTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException {
    	traineeRepo.removeTrainee(cohort, trainee);
    }
    @Override
    public  Trainee findByName(String cohort, String fullName) throws InvalidTraineeOperationException{
        return traineeRepo.findByName(cohort, fullName);
    }

    @Override
    public List<Trainee> findAll(String cohort) {
        return traineeRepo.findAll(cohort);
    }
}
